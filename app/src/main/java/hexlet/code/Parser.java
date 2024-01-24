package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import java.util.Map;

public final class Parser {
    private ObjectMapper mapper;

    private Parser(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public static Parser createParser(String type)
            throws Exception {
        switch (type.toLowerCase()) {
            case "json":
                return new Parser(new JsonMapper());
            case "yaml":
            case "yml":
                return new Parser(new YAMLMapper());
            default:
                throw new IllegalArgumentException("Unknown parser type: " + type);
        }
    }

    public Map<String, Object> parse(String text)
            throws Exception {
        return mapper.readValue(text, new TypeReference<Map<String, Object>>() { });
    }
}
