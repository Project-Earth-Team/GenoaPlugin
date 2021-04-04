package dev.projectearth.genoa_plugin.utils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.cloudburstmc.server.block.BlockPalette;
import org.cloudburstmc.server.block.BlockState;
import org.cloudburstmc.server.registry.BlockRegistry;
import org.cloudburstmc.server.utils.Identifier;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@NoArgsConstructor
@EqualsAndHashCode
public class PaletteBlock {
    private int data;
    private String name;

    @JsonIgnore
    private BlockState state;

    public PaletteBlock(String name, int data) {
        this.name = name;
        this.data = data;
    }

    @JsonIgnore
    public BlockState getState() {
        if (state == null) {
            state = BlockRegistry.get().getBlock(Identifier.fromString(name), data);
        }

        return state;
    }

    public static PaletteBlock from(BlockState block) {
        // TODO: fix the data/meta
        return new PaletteBlock(block.getId().toString(), BlockPalette.INSTANCE.getSerialized(block).getShort("val"));
    }
}
