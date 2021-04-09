package dev.projectearth.genoa_plugin.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.nukkitx.math.vector.Vector3f;

import java.io.IOException;

/**
 * Serializer for Jackson json to create {@link Vector3f}
 */
public class Vector3fSerializer extends JsonSerializer<Vector3f> {

    @Override
    public void serialize(Vector3f vector3f, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("x", vector3f.getZ());
        jsonGenerator.writeNumberField("y", vector3f.getY());
        jsonGenerator.writeNumberField("z", vector3f.getX());
        jsonGenerator.writeEndObject();
    }
}
