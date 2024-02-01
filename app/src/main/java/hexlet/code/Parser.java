package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import java.util.Map;

public final class Parser {

    public static Map<String, Object> parse(String text, String type)
            throws Exception {
        var returnType = new TypeReference<Map<String, Object>>() {
        };
        switch (type.toLowerCase()) {
            case "json":
                return new JsonMapper().readValue(text, returnType);
            case "yaml":
            case "yml":
                return new YAMLMapper().readValue(text, returnType);
            default:
                throw new IllegalArgumentException("Unknown parser type: " + type);
        }
    }
}
