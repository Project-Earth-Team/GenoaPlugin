package dev.projectearth.genoa_plugin.utils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
public class BuildplateModel {
    private Object[] blockEntities;
    private BuildplateEntity[] entities;
    @JsonProperty("format_version")
    private int formatVersion;
    private boolean isNight;
    @JsonProperty("sub_chunks")
    private SubChunk[] subChunks;
}
