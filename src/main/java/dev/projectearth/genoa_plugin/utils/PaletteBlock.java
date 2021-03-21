package dev.projectearth.genoa_plugin.utils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import org.cloudburstmc.server.block.BlockState;
import org.cloudburstmc.server.registry.BlockRegistry;
import org.cloudburstmc.server.utils.Identifier;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
public class PaletteBlock {
    private int data;
    private String name;

    private BlockState state;

    public BlockState getState() {
        if (state == null) {
            state = BlockRegistry.get().getBlock(Identifier.fromString(name), data);
        }

        return state;
    }
}
