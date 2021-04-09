package dev.projectearth.genoa_plugin.utils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.nukkitx.math.vector.Vector3i;
import dev.projectearth.genoa_plugin.deserializers.Vector3iDeserializer;
import dev.projectearth.genoa_plugin.serializers.Vector3iSerializer;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class BuildplateBlockEntity {
    private Object data; //NBT
    @JsonDeserialize(using = Vector3iDeserializer.class)
    @JsonSerialize(using = Vector3iSerializer.class)
    private Vector3i position;
    private int type;
}
