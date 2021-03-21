package dev.projectearth.genoa_plugin.utils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.nukkitx.math.vector.Vector3i;
import dev.projectearth.genoa_plugin.deserializers.Vector3iDeserializer;
import lombok.Getter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
public class SubChunk {
    @JsonProperty("block_palette")
    private PaletteBlock[] blockPalette;
    private int[] blocks;
    @JsonDeserialize(using = Vector3iDeserializer.class)
    private Vector3i position;
}
