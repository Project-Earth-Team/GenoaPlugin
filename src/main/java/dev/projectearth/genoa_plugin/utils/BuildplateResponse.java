package dev.projectearth.genoa_plugin.utils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class BuildplateResponse {
    private Buildplate result;
}


