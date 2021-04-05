package dev.projectearth.genoa_plugin.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.Base64;

/**
 * Serializer for Jackson json to encode json as base64
 */
public class Base64Serializer extends JsonSerializer<Object> {

    @Override
    public void serialize(Object o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        Base64.Encoder encoder = Base64.getEncoder();

        ObjectMapper objectMapper = new ObjectMapper();
        byte[] json = objectMapper.writeValueAsBytes(o);
        String b64json = encoder.encodeToString(json);

        jsonGenerator.writeString(b64json);
    }
}
