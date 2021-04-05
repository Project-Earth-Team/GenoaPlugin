package dev.projectearth.genoa_plugin.utils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.nukkitx.math.vector.Vector2f;
import com.nukkitx.math.vector.Vector3f;
import dev.projectearth.genoa_plugin.deserializers.Vector2fDeserializer;
import dev.projectearth.genoa_plugin.deserializers.Vector3fDeserializer;
import dev.projectearth.genoa_plugin.serializers.Vector2fSerializer;
import dev.projectearth.genoa_plugin.serializers.Vector3fSerializer;
import lombok.Getter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
public class BuildplateEntity {
    private int changeColor;
    private int multiplicitiveTintChangeColor;
    private String name;
    private int overlayColor;
    @JsonDeserialize(using = Vector3fDeserializer.class)
    @JsonSerialize(using = Vector3fSerializer.class)
    private Vector3f position;
    @JsonDeserialize(using = Vector2fDeserializer.class)
    @JsonSerialize(using = Vector2fSerializer.class)
    private Vector2f rotation;
    @JsonDeserialize(using = Vector3fDeserializer.class)
    @JsonSerialize(using = Vector3fSerializer.class)
    private Vector3f shadowPosition;
    private float shadowSize;
}
