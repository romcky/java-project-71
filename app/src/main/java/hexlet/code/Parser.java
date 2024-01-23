package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import java.util.Map;

public class Parser {
    private static JsonMapper jsonMapper = new JsonMapper();
    private static ObjectMapper objectMapper = new ObjectMapper();

    public static Map<String, Object> jsonToMap(String text)
            throws Exception {
        return jsonMapper.readValue(text, new TypeReference<>() { });
    }

    public static String mapToJson(Map<String, Object> map)
            throws Exception {
        return objectMapper.writeValueAsString(map);
    }

    public static String mapToStylish(Map<String, Object> map) {
        var builder = new StringBuilder("{\n");
        for (var entry : map.entrySet()) {
            builder.append("  ").append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }
        return builder.append("}").toString();
    }

}
