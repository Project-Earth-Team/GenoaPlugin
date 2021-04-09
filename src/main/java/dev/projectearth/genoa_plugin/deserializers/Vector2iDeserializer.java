package dev.projectearth.genoa_plugin.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.nukkitx.math.vector.Vector2i;

import java.io.IOException;

/**
 * Deserializer for Jackson json to create {@link Vector2i}
 */
public class Vector2iDeserializer extends JsonDeserializer<Vector2i> {

    @Override
    public Vector2i deserialize(JsonParser parser, DeserializationContext context) throws IOException {
        JsonNode node = parser.getCodec().readTree(parser);
        return Vector2i.from(node.get("x").asInt(), node.get("z").asInt());
    }
}
