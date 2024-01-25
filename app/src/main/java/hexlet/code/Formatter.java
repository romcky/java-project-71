package hexlet.code;

import java.util.Map;
import java.util.function.Function;

public final class Formatter {
    private Function<Map<String, Object>, String> formatter;

    private Formatter(Function<Map<String, Object>, String> formatter) {
        this.formatter = formatter;
    }

    public static Formatter createFormatter(String type) {
        switch (type) {
            case "stylish":
                return new Formatter(new Stylish());
            default:
                throw new IllegalArgumentException("Unknown formatter type: " + type);
        }
    }

    public String format(Map<String, Object> diff) {
        return formatter.apply(diff);
    }
}
