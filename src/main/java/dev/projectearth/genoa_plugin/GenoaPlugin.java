package dev.projectearth.genoa_plugin;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Inject;
import dev.projectearth.genoa_plugin.commands.BuildplateCommand;
import dev.projectearth.genoa_plugin.generators.BuildplateGenerator;
import dev.projectearth.genoa_plugin.utils.Buildplate;
import dev.projectearth.genoa_plugin.utils.BuildplateEntity;
import lombok.Getter;
import org.cloudburstmc.api.level.gamerule.GameRules;
import org.cloudburstmc.api.plugin.PluginContainer;
import org.cloudburstmc.server.CloudServer;
import org.cloudburstmc.server.entity.Entity;
import org.cloudburstmc.server.level.Level;
import org.cloudburstmc.server.level.Location;
import org.cloudburstmc.server.level.storage.StorageIds;
import org.cloudburstmc.server.registry.CommandRegistry;
import org.cloudburstmc.server.registry.EntityRegistry;
import org.cloudburstmc.server.registry.GeneratorRegistry;
import org.cloudburstmc.server.utils.Identifier;
import org.slf4j.Logger;
import org.cloudburstmc.api.plugin.Plugin;
import org.cloudburstmc.api.plugin.PluginDescription;
import org.cloudburstmc.server.event.Listener;
import org.cloudburstmc.server.event.player.PlayerJoinEvent;
import org.cloudburstmc.server.event.server.ServerInitializationEvent;

import javax.annotation.Nonnull;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@Plugin(id = "GenoaPlugin", name = "Genoa Plugin", version = "1.0.0")
public class GenoaPlugin implements PluginContainer {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private static GenoaPlugin INSTANCE;

    @Getter
    private final Logger logger;
    @Getter
    private final PluginDescription description;
    @Getter
    private final Path dataDirectory;
    private final CloudServer server;

    @Getter
    private Map<String, Buildplate> buildplates = new HashMap<>();

    @Inject
    private GenoaPlugin(Logger logger, PluginDescription description, Path dataDirectory) {
        this.logger = logger;
        this.description = description;
        this.dataDirectory = dataDirectory;

        this.server = CloudServer.getInstance();
        INSTANCE = this;
    }

    @Listener
    public void onInitialization(ServerInitializationEvent event) {
        this.logger.info("Genoa plugin loading...");
        GeneratorRegistry.get().register(BuildplateGenerator.ID, BuildplateGenerator::new, 0);
        CommandRegistry.get().register(this, new BuildplateCommand());

        //registerBuildplate("test");

        this.logger.info("Genoa plugin has loaded!");
    }

    public Level registerBuildplate(String buildplateId) {
        try {
            this.logger.info("Downloading buildplate " + buildplateId + "...");
            File buildplateFile = new File(buildplateId + ".json");
            if (!buildplateFile.exists()) {
                // TODO: Download from server
                return null;
            }

            this.logger.info("Loading buildplate " + buildplateId + "...");
            buildplates.put(buildplateId, OBJECT_MAPPER.readValue(buildplateFile, Buildplate.class));

            this.logger.info("Creating level for buildplate " + buildplateId + "...");
            Level buildplateLevel = server.loadLevel()
                    .id(buildplateId)
                    .seed(0)
                    .generator(BuildplateGenerator.ID)
                    .generatorOptions(buildplateId)
                    .storage(StorageIds.LEVELDB)
                    .load()
                    .get();

            buildplateLevel.getGameRules().put(GameRules.DO_DAYLIGHT_CYCLE, false);
            buildplateLevel.getGameRules().put(GameRules.DO_WEATHER_CYCLE, false);
            buildplateLevel.getGameRules().put(GameRules.SHOW_COORDINATES, true);

            server.setDefaultLevel(buildplateLevel);

            return buildplateLevel;
        } catch (InterruptedException | ExecutionException | IOException e) {
            logger.error("Something went wrong loading buildplate '" + buildplateId + "':", e);
        }

        return null;
    }

    @Listener
    public void onJoin(PlayerJoinEvent event) {
        // TODO: Cache if we have spawned the ents
        if (event.getPlayer().getLevel().getGenerator().getClass() == BuildplateGenerator.class) {
            for (BuildplateEntity entity : buildplates.get(event.getPlayer().getLevel().getId()).getResult().getBuildplateData().getModel().getEntities()) {
                Entity ent = EntityRegistry.get().newEntity(EntityRegistry.get().getEntityType(Identifier.fromString(entity.getName())), Location.from(entity.getPosition(), event.getPlayer().getLevel()));
                ent.setPosition(entity.getPosition());
                ent.setRotation(entity.getRotation().getX(), entity.getRotation().getY());
                logger.info("Spawning " + ent.getName() + " at " + entity.getPosition());
                ent.spawnToAll();
            }
        }
    }

    public static GenoaPlugin get() {
        return INSTANCE;
    }

    @Nonnull
    @Override
    public Object getPlugin() {
        return this;
    }
}
