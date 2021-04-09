package dev.projectearth.genoa_plugin.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.nukkitx.math.vector.Vector2f;

import java.io.IOException;

/**
 * Deserializer for Jackson json to create {@link Vector2f}
 */
public class Vector2fDeserializer extends JsonDeserializer<Vector2f> {

    @Override
    public Vector2f deserialize(JsonParser parser, DeserializationContext context) throws IOException {
        JsonNode node = parser.getCodec().readTree(parser);
        return Vector2f.from(node.get("x").asDouble(), node.get("y").asDouble());
    }
}
