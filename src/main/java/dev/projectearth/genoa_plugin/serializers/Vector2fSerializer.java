package dev.projectearth.genoa_plugin.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.nukkitx.math.vector.Vector2f;

import java.io.IOException;

/**
 * Serializer for Jackson json to create {@link Vector2f}
 */
public class Vector2fSerializer extends JsonSerializer<Vector2f> {

    @Override
    public void serialize(Vector2f vector2f, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("x", vector2f.getX());
        jsonGenerator.writeNumberField("y", vector2f.getY());
        jsonGenerator.writeEndObject();
    }
}
