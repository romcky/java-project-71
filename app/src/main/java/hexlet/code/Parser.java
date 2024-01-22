package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;
import java.util.HashMap;

public class Parser {
    private static ObjectMapper objectMapper = new ObjectMapper();

    public static Map<String, Object> parse(String text) 
            throws Exception {
        var resultMap = new HashMap<String, Object>();
        resultMap = objectMapper.readValue(text, resultMap.getClass());
        return resultMap;
    }

}
