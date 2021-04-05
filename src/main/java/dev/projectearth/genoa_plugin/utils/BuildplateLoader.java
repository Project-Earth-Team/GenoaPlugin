package dev.projectearth.genoa_plugin.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.projectearth.genoa_plugin.GenoaPlugin;
import dev.projectearth.genoa_plugin.generators.VoidGenerator;
import dev.projectearth.genoa_plugin.providers.JsonLevelProvider;
import org.cloudburstmc.api.level.gamerule.GameRules;
import org.cloudburstmc.server.CloudServer;
import org.cloudburstmc.server.entity.Entity;
import org.cloudburstmc.server.level.Level;
import org.cloudburstmc.server.level.Location;
import org.cloudburstmc.server.registry.CloudGameRuleRegistry;
import org.cloudburstmc.server.registry.EntityRegistry;
import org.cloudburstmc.server.utils.Identifier;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class BuildplateLoader {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static Level registerBuildplate(String buildplateId) {
        try {
            GenoaPlugin.get().getLogger().info("Downloading buildplate " + buildplateId + "...");
            File buildplateFile = new File(buildplateId + ".json");
            if (!buildplateFile.exists()) {
                // TODO: Download from server
                return null;
            }

            GenoaPlugin.get().getLogger().info("Loading buildplate " + buildplateId + "...");
            BuildplateResponse buildplateResponse = OBJECT_MAPPER.readValue(buildplateFile, BuildplateResponse.class);
            GenoaPlugin.get().getBuildplates().put(buildplateId, buildplateResponse.getResult());

            GenoaPlugin.get().getLogger().info("Creating level for buildplate " + buildplateId + "...");
            Level buildplateLevel = CloudServer.getInstance().loadLevel()
                    .id(buildplateId)
                    .seed(0)
                    .generator(VoidGenerator.ID)
                    .storage(JsonLevelProvider.ID)
                    .load()
                    .get();

            return buildplateLevel;
        } catch (InterruptedException | ExecutionException | IOException e) {
            GenoaPlugin.get().getLogger().error("Something went wrong loading buildplate '" + buildplateId + "':", e);
        }

        return null;
    }
}
