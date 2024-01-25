package hexlet.code;

import java.util.Map;
import java.util.function.Function;

public class Stylish implements Function<Map<String, Object>, String> {

    @Override
    public String apply(Map<String, Object> diff) {
        var bld = new StringBuilder("{\n");
        for (var entry : diff.entrySet()) {
            bld.append("  ").append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }
        return bld.append("}").toString();
    }
}
