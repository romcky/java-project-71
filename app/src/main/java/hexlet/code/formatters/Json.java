package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Json {

    public static String format(List<Map<String, Object>> diffList)
            throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(diffList);
    }
}
