package dev.projectearth.genoa_plugin;

import com.google.inject.Inject;
import com.nukkitx.protocol.genoa.packet.GenoaItemParticlePacket;
import dev.projectearth.genoa_plugin.commands.BuildplateCommand;
import dev.projectearth.genoa_plugin.commands.SummonCommand;
import dev.projectearth.genoa_plugin.commands.TestEntCommand;
import dev.projectearth.genoa_plugin.entities.GenoaEntityLoader;
import dev.projectearth.genoa_plugin.generators.VoidGenerator;
import dev.projectearth.genoa_plugin.providers.JsonLevelProvider;
import dev.projectearth.genoa_plugin.providers.JsonLevelProviderFactory;
import dev.projectearth.genoa_plugin.utils.Buildplate;
import lombok.Getter;
import org.cloudburstmc.api.plugin.PluginContainer;
import org.cloudburstmc.server.CloudServer;
import org.cloudburstmc.server.event.block.BlockBreakEvent;
import org.cloudburstmc.server.registry.CommandRegistry;
import org.cloudburstmc.server.registry.GeneratorRegistry;
import org.cloudburstmc.server.registry.StorageRegistry;
import org.slf4j.Logger;
import org.cloudburstmc.api.plugin.Plugin;
import org.cloudburstmc.api.plugin.PluginDescription;
import org.cloudburstmc.server.event.Listener;
import org.cloudburstmc.server.event.player.PlayerJoinEvent;
import org.cloudburstmc.server.event.server.ServerInitializationEvent;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

@Plugin(id = "GenoaPlugin", name = "Genoa Plugin", version = "1.0.0")
public class GenoaPlugin implements PluginContainer {
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
        GeneratorRegistry.get().register(VoidGenerator.ID, VoidGenerator::new, 0);
        StorageRegistry.get().register(JsonLevelProvider.ID, JsonLevelProviderFactory.INSTANCE, 0);
        CommandRegistry.get().register(this, new BuildplateCommand());
        CommandRegistry.get().register(this, new TestEntCommand());
        CommandRegistry.get().register(this, new SummonCommand());
        GenoaEntityLoader.load();
        this.logger.info("Genoa plugin has loaded!");
    }

    @Listener
    public void onBlockBreak(BlockBreakEvent event) {
        GenoaItemParticlePacket packet = new GenoaItemParticlePacket();
        packet.setPosition(event.getBlock().getPosition().toFloat().add(0.5, 0.5, 0.5));
        packet.setParticleId(5); // TODO: Find out if 5 always works, or if we need multiple particles
        packet.setDimensionId(1);
        packet.setUniqueEntityId(event.getPlayer().getUniqueId());
        event.getPlayer().sendPacket(packet);
        //this.logger.info("Sent block breaking packet!");
    }

    @Listener
    public void onJoin(PlayerJoinEvent event) {
        // TODO: Load the buildplate for the user or kick them
    }

    public static GenoaPlugin get() {
        return INSTANCE;
    }

    @Override
    public Object getPlugin() {
        return this;
    }
}
