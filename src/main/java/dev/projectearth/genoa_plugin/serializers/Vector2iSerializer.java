package dev.projectearth.genoa_plugin.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.nukkitx.math.vector.Vector2i;

import java.io.IOException;

/**
 * Serializer for Jackson json to create {@link Vector2i}
 */
public class Vector2iSerializer extends JsonSerializer<Vector2i> {

    @Override
    public void serialize(Vector2i vector2i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("x", vector2i.getX());
        jsonGenerator.writeNumberField("z", vector2i.getY());
        jsonGenerator.writeEndObject();
    }
}
