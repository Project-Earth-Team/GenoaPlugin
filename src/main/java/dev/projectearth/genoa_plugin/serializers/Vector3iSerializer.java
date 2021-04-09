package dev.projectearth.genoa_plugin.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.*;
import com.nukkitx.math.vector.Vector3i;

import java.io.IOException;

/**
 * Serializer for Jackson json to create {@link Vector3i}
 */
public class Vector3iSerializer extends JsonSerializer<Vector3i> {

    @Override
    public void serialize(Vector3i vector3i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("x", vector3i.getZ());
        jsonGenerator.writeNumberField("y", vector3i.getY());
        jsonGenerator.writeNumberField("z", vector3i.getX());
        jsonGenerator.writeEndObject();
    }
}
