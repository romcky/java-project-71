package hexlet.code;

import java.util.List;
import java.util.Map;
import hexlet.code.formatters.Stylish;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Json;

public final class Formatter {
/*
    public static DifferenceFormatter createFormatter(String type) {
        switch (type.toLowerCase()) {
            case "stylish":
                return new Stylish();
            case "plain":
                return new Plain();
            case "json":
                return new Json();
            default:
                throw new IllegalArgumentException("Unknown formatter type: " + type);
        }
    }

 */
    public static String format(List<Map<String, Object>> diffList, String type)
            throws Exception {
        switch (type.toLowerCase()) {
            case "stylish":
                return Stylish.format(diffList);
            case "plain":
                return Plain.format(diffList);
            case "json":
                return Json.format(diffList);
            default:
                throw new IllegalArgumentException("Unknown formatter type: " + type);
        }
    }
}
