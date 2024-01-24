package hexlet.code;

import java.util.Map;

public class Converter {

    public static String convert(Map<String, Object> map) {
        var builder = new StringBuilder("{\n");
        for (var entry : map.entrySet()) {
            builder.append("  ").append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }
        return builder.append("}").toString();
    }

}
