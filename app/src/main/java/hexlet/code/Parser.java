package hexlet.code;

import com.fasterxml.jackson.databind.json.JsonMapper;
import java.util.Map;
import java.util.HashMap;

public class Parser {
    private static JsonMapper jsonMapper = new JsonMapper();

    public static Map<String, Object> parse(String text)
            throws Exception {
        var resultMap = new HashMap<String, Object>();
        resultMap = jsonMapper.readValue(text, resultMap.getClass());
        return resultMap;
    }

}
