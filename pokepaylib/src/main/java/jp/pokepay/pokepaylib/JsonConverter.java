package jp.pokepay.pokepaylib;

import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.Map;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonConverter {

    private static ObjectMapper mapper = new ObjectMapper();

    public static String toString(final Map<String, Object> map)
            throws JsonGenerationException, JsonMappingException, IOException {
        String json = mapper.writeValueAsString(map);
        return json;
    }

    public static <T> T toObject(final String jsonString, final Class<T> cls)
            throws JsonParseException, JsonMappingException, IOException {
        T object = null;
        if (jsonString == null) {
            throw new InvalidParameterException("jsonString is null.");
        }
        object = mapper.readValue(jsonString, cls);
        return object;
    }

    public static <T> T toObject(String jsonString, TypeReference<T> valueTypeRef)
            throws JsonParseException, JsonMappingException, IOException {
        T object = null;
        if (jsonString == null) {
            throw new InvalidParameterException("jsonString is null.");
        }
        object = mapper.readValue(jsonString, valueTypeRef);
        return object;
    }
}