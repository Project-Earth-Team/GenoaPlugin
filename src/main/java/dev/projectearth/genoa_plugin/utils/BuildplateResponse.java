package dev.projectearth.genoa_plugin.utils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
public class BuildplateResponse {
    private Buildplate result;
}


