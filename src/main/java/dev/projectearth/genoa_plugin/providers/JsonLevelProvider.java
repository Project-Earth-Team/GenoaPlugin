package dev.projectearth.genoa_plugin.providers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nukkitx.math.vector.Vector3i;
import dev.projectearth.genoa_plugin.GenoaPlugin;
import dev.projectearth.genoa_plugin.utils.*;
import org.cloudburstmc.api.level.gamerule.GameRules;
import org.cloudburstmc.server.level.LevelData;
import org.cloudburstmc.server.level.chunk.Chunk;
import org.cloudburstmc.server.level.chunk.ChunkBuilder;
import org.cloudburstmc.server.level.chunk.ChunkSection;
import org.cloudburstmc.server.level.provider.LevelProvider;
import org.cloudburstmc.server.registry.CloudGameRuleRegistry;
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

    private final String levelId;
    private final Path levelsPath;
    private final Executor executor;
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

            List<BuildplateEntity> entities = new ArrayList<>();

            int rawX = chunkBuilder.getX() * 16;
            int rawZ = chunkBuilder.getZ() * 16;
            if (buildplate.getBuildplateData().getModel().getEntities() != null) {
                for (BuildplateEntity entity : buildplate.getBuildplateData().getModel().getEntities()) {
                    if (entity.getPosition().getX() >= rawX && rawX < entity.getPosition().getX() + 16
                            && entity.getPosition().getZ() >= rawZ && rawZ < entity.getPosition().getZ() + 16) {
                        entities.add(entity);
                    }
                }
            }

            // TODO: Work out why this is called a tonne
            chunkBuilder.dataLoader(new EntityDataLoader(entities));

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
        return CompletableFuture.runAsync(() -> {
            for (int subChunkY = 0; subChunkY < chunk.getSections().length; subChunkY++) {
                ChunkSection section = chunk.getSection(subChunkY);

                if (section == null || section.isEmpty()) {
                    continue;
                }

                SubChunk subChunk = new SubChunk();
                subChunk.setPosition(Vector3i.from(chunk.getZ(), subChunkY, chunk.getX()));
                List<PaletteBlock> paletteBlocks = new ArrayList<>();
                int[] blocks = new int[16 * 16 * 16];

                for (int x = 0; x < 16; x++) {
                    for (int z = 0; z < 16; z++) {
                        for (int y = 0; y < 16; y++) {
                            PaletteBlock block = PaletteBlock.from(section.getBlock(x, y, z, 0));

                            int stateIndex = paletteBlocks.indexOf(block);
                            if (stateIndex == -1) {
                                stateIndex = paletteBlocks.size();
                                paletteBlocks.add(block);
                            }

                            blocks[from3D(x, y, z)] = stateIndex;
                        }
                    }
                }

                subChunk.setBlocks(blocks);
                subChunk.setBlockPalette(paletteBlocks.toArray(new PaletteBlock[0]));

                // Replace the sub chunk in the array
                boolean replaced = false;
                for (int i = 0; i < buildplate.getBuildplateData().getModel().getSubChunks().length; i++) {
                    SubChunk tmpSubChunk = buildplate.getBuildplateData().getModel().getSubChunks()[i];
                    if (tmpSubChunk.getPosition().equals(subChunk.getPosition())) {
                        buildplate.getBuildplateData().getModel().getSubChunks()[i] = subChunk;
                        replaced = true;
                        break;
                    }
                }

                // Expand the array and insert the new sub chunk
                if (!replaced) {
                    SubChunk[] newSubChunks = new SubChunk[buildplate.getBuildplateData().getModel().getSubChunks().length + 1];
                    System.arraycopy(buildplate.getBuildplateData().getModel().getSubChunks(), 0, newSubChunks, 0, buildplate.getBuildplateData().getModel().getSubChunks().length);
                    newSubChunks[newSubChunks.length - 1] = subChunk;
                    buildplate.getBuildplateData().getModel().setSubChunks(newSubChunks);
                }
            }

            System.out.println("Saved chunk: " + chunk.getX() + ", " + chunk.getZ());
        }, this.executor);
    }

    @Override
    public CompletableFuture<Void> forEachChunk(ChunkBuilder.Factory factory, BiConsumer<Chunk, Throwable> consumer) {
        return CompletableFuture.runAsync(() -> {}, this.executor);
    }

    @Override
    public CompletableFuture<LoadState> loadLevelData(LevelData levelData) {
        return CompletableFuture.supplyAsync(() -> {
            // Insert default rules
            levelData.getGameRules().putAll(CloudGameRuleRegistry.get().getDefaultRules());

            // Change a few to disable features
            levelData.getGameRules().put(GameRules.DO_DAYLIGHT_CYCLE, false);
            levelData.getGameRules().put(GameRules.DO_WEATHER_CYCLE, false);

            // Set the time
            levelData.setTime(buildplate.getBuildplateData().getModel().isNight() ? 18000L : 6000L);

            // Set the spawn
            levelData.setSpawn(buildplate.getBuildplateData().getOffset());

            return LoadState.LOADED;
        }, this.executor);
    }

    @Override
    public CompletableFuture<Void> saveLevelData(LevelData levelData) {
        return CompletableFuture.runAsync(() -> {});
    }

    @Override
    public void close() throws IOException {
        BuildplateResponse response = new BuildplateResponse();
        response.setResult(buildplate);

        OBJECT_MAPPER.writeValue(levelsPath.resolve(levelId + ".json").toFile(), response);
        System.out.println("Saved " + levelId + ".json");
    }

    private static Vector3i to3D(int index) {
        int x = index % 16;
        int y = (int) Math.floor((index / 16f) % 16f);
        int z = (int) Math.floor(index / (16f * 16f));
        return Vector3i.from(x, y, z);
    }

    private static int from3D(int x, int y, int z) {
        return x + 16 * (y + 16 * z);
    }
}
