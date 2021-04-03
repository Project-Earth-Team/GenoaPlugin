package dev.projectearth.genoa_plugin.generators;

import com.nukkitx.math.vector.Vector3i;
import dev.projectearth.genoa_plugin.GenoaPlugin;
import dev.projectearth.genoa_plugin.utils.Buildplate;
import dev.projectearth.genoa_plugin.utils.PaletteBlock;
import dev.projectearth.genoa_plugin.utils.SubChunk;
import net.daporkchop.lib.random.PRandom;
import org.cloudburstmc.server.level.ChunkManager;
import org.cloudburstmc.server.level.chunk.IChunk;
import org.cloudburstmc.server.level.generator.Generator;
import org.cloudburstmc.server.utils.Identifier;

/**
 * A basic generator for buildplate worlds.
 *
 * @author rtm516
 */
public final class BuildplateGenerator implements Generator {
    public static final Identifier ID = Identifier.from("genoa", "buildplate");
    private Buildplate buildplate;

    public BuildplateGenerator(long seed, String options) {
        this.buildplate = GenoaPlugin.get().getBuildplates().get(options);
    }

    @Override
    public void generate(PRandom random, IChunk chunk, int chunkX, int chunkZ) {
        for (SubChunk subChunk : buildplate.getBuildplateData().getModel().getSubChunks()) {
            if (subChunk.getPosition().getZ() == chunkX && subChunk.getPosition().getX() == chunkZ) {
                for (int i = 0; i < subChunk.getBlocks().length; i++) {
                    PaletteBlock block = subChunk.getBlockPalette()[subChunk.getBlocks()[i]];
                    Vector3i pos = to3D(i).add(0, subChunk.getPosition().getY() * 16, 0);
                    chunk.setBlock(pos.getX(), pos.getY(), pos.getZ(), block.getState());
                }
            }
        }
    }

    @Override
    public void populate(PRandom random, ChunkManager level, int chunkX, int chunkZ) {
        //no-op
    }

    @Override
    public void finish(PRandom random, ChunkManager level, int chunkX, int chunkZ) {
        //no-op
    }

    private static Vector3i to3D(int index) {
        int x = index % 16;
        int y = (int) Math.floor((index / 16f) % 16f);
        int z = (int) Math.floor(index / (16f * 16f));
        return Vector3i.from(x, y, z);
    }
}
