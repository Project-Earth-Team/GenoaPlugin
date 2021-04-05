package dev.projectearth.genoa_plugin.utils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.nukkitx.math.vector.Vector2i;
import com.nukkitx.math.vector.Vector3i;
import dev.projectearth.genoa_plugin.deserializers.Base64Deserializer;
import dev.projectearth.genoa_plugin.deserializers.Vector2iDeserializer;
import dev.projectearth.genoa_plugin.deserializers.Vector3iDeserializer;
import dev.projectearth.genoa_plugin.serializers.Base64Serializer;
import dev.projectearth.genoa_plugin.serializers.Vector2iSerializer;
import dev.projectearth.genoa_plugin.serializers.Vector3iSerializer;
import lombok.Getter;

import java.util.UUID;

/**
 * This uses non-primitive types so values can be excluded when they are null
 * TODO: Change this when we move over to reading buildplate data and not share data
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
public class BuildplateData {
    private UUID id;
    private String type;
    private Integer numberOfBlocks;
    private String eTag;
    @JsonDeserialize(using = Base64Deserializer.class)
    @JsonSerialize(using = Base64Serializer.class)
    private BuildplateModel model;
    @JsonDeserialize(using = Vector3iDeserializer.class)
    @JsonSerialize(using = Vector3iSerializer.class)
    private Vector3i offset;
    @JsonDeserialize(using = Vector2iDeserializer.class)
    @JsonSerialize(using = Vector2iSerializer.class)
    private Vector2i dimension;
    private Float blocksPerMeter;
    private String surfaceOrientation;
    private Boolean locked;
    private Integer requiredLevel;
    private Integer order;
    private Boolean isModified;
    private UUID templateId;
}
