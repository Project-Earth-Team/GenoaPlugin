package dev.projectearth.genoa_plugin.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.nukkitx.math.vector.Vector3f;

import java.io.IOException;

/**
 * Deserializer for Jackson json to create {@link Vector3f}
 */
public class Vector3fDeserializer extends JsonDeserializer<Vector3f> {

    @Override
    public Vector3f deserialize(JsonParser parser, DeserializationContext context) throws IOException {
        JsonNode node = parser.getCodec().readTree(parser);
        return Vector3f.from(node.get("x").asDouble(), node.get("y").asDouble(), node.get("z").asDouble());
    }
}
