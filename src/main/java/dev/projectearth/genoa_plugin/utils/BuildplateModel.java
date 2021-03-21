package dev.projectearth.genoa_plugin.utils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
public class BuildplateModel {
    @JsonProperty("sub_chunks")
    private SubChunk[] subChunks;
    private BuildplateEntity[] entities;
}
