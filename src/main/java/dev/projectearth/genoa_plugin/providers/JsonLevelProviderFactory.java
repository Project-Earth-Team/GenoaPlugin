package dev.projectearth.genoa_plugin.providers;

import org.cloudburstmc.server.level.provider.LevelProvider;
import org.cloudburstmc.server.level.provider.LevelProviderFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.concurrent.Executor;

public class JsonLevelProviderFactory implements LevelProviderFactory {

    public static final JsonLevelProviderFactory INSTANCE = new JsonLevelProviderFactory();

    @Override
    public LevelProvider create(String levelId, Path levelsPath, Executor executor) {
        return new JsonLevelProvider(levelId, levelsPath, executor);
    }

    @Override
    public boolean isCompatible(String levelId, Path levelsPath) {
        File levelJson = levelsPath.resolve(levelId + ".json").toFile();
        return levelJson.exists();
    }
}
