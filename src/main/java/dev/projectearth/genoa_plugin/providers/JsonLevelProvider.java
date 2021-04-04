package dev.projectearth.genoa_plugin.providers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nukkitx.math.vector.Vector3i;
import dev.projectearth.genoa_plugin.GenoaPlugin;
import dev.projectearth.genoa_plugin.utils.Buildplate;
import dev.projectearth.genoa_plugin.utils.BuildplateResponse;
import dev.projectearth.genoa_plugin.utils.PaletteBlock;
import dev.projectearth.genoa_plugin.utils.SubChunk;
import org.cloudburstmc.server.level.LevelData;
import org.cloudburstmc.server.level.chunk.Chunk;
import org.cloudburstmc.server.level.chunk.ChunkBuilder;
import org.cloudburstmc.server.level.chunk.ChunkSection;
import org.cloudburstmc.server.level.provider.LevelProvider;
import org.cloudburstmc.server.utils.Identifier;
import org.cloudburstmc.server.utils.LoadState;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.BiConsumer;

public class JsonLevelProvider implements LevelProvider {
    public static final Identifier ID = Identifier.from("genoa", "json");

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private String levelId;
    private Path levelsPath;
    private Executor executor;
    private Buildplate buildplate;

    public JsonLevelProvider(String levelId, Path levelsPath, Executor executor) {
        this.levelId = levelId;
        this.levelsPath = levelsPath;
        this.executor = executor;

        GenoaPlugin.get().getLogger().info("Loading json " + levelId + "...");
        try {
            BuildplateResponse buildplateResponse = OBJECT_MAPPER.readValue(levelsPath.resolve(levelId + ".json").toFile(), BuildplateResponse.class);
            this.buildplate = buildplateResponse.getResult();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getLevelId() {
        return levelId;
    }

    @Override
    public CompletableFuture<Chunk> readChunk(ChunkBuilder chunkBuilder) {
        return CompletableFuture.supplyAsync(() -> {
            ChunkSection[] chunkSections = new ChunkSection[16];

            for (SubChunk subChunk : buildplate.getBuildplateData().getModel().getSubChunks()) {
                if (subChunk.getPosition().getZ() == chunkBuilder.getX() && subChunk.getPosition().getX() == chunkBuilder.getZ()) {
                    ChunkSection chunkSection = new ChunkSection();

                    for (int i = 0; i < subChunk.getBlocks().length; i++) {
                        PaletteBlock block = subChunk.getBlockPalette()[subChunk.getBlocks()[i]];
                        Vector3i pos = to3D(i);//.add(0, subChunk.getPosition().getY() * 16, 0);
                        chunkSection.setBlock(pos.getX(), pos.getY(), pos.getZ(), 0, block.getState());
                    }

                    chunkSections[subChunk.getPosition().getY()] = chunkSection;
                }
            }

            chunkBuilder.sections(chunkSections);

            int[] heights = new int[512];
            Arrays.fill(heights, 256);
            chunkBuilder.heightMap(heights);

            byte[] biomes = new byte[256];
            Arrays.fill(biomes, (byte) 0);
            chunkBuilder.biomes(biomes);

            return chunkBuilder.build();
        }, this.executor);
    }

    @Override
    public CompletableFuture<Void> saveChunk(Chunk chunk) {
        return CompletableFuture.runAsync(() -> {}, this.executor);
    }

    @Override
    public CompletableFuture<Void> forEachChunk(ChunkBuilder.Factory factory, BiConsumer<Chunk, Throwable> consumer) {
        return CompletableFuture.runAsync(() -> {}, this.executor);
    }

    @Override
    public CompletableFuture<LoadState> loadLevelData(LevelData levelData) {
        return CompletableFuture.supplyAsync(() -> LoadState.LOADED, this.executor);
    }

    @Override
    public CompletableFuture<Void> saveLevelData(LevelData levelData) {
        return CompletableFuture.runAsync(() -> {});
    }

    @Override
    public void close() throws IOException {

    }

    private static Vector3i to3D(int index) {
        int x = index % 16;
        int y = (int) Math.floor((index / 16f) % 16f);
        int z = (int) Math.floor(index / (16f * 16f));
        return Vector3i.from(x, y, z);
    }
}
