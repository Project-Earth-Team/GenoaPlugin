package dev.projectearth.genoa_plugin.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.nukkitx.math.vector.Vector3i;

import java.io.IOException;

/**
 * Deserializer for Jackson json to create {@link Vector3i}
 */
public class Vector3iDeserializer extends JsonDeserializer<Vector3i> {

    @Override
    public Vector3i deserialize(JsonParser parser, DeserializationContext context) throws IOException {
        JsonNode node = parser.getCodec().readTree(parser);
        return Vector3i.from(node.get("x").asInt(), node.get("y").asInt(), node.get("z").asInt());
    }
}
