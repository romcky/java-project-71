package hexlet.code.formatters;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Plain {

    public static String format(List<Map<String, Object>> diffList) {
        return diffList.stream()
                .map(Plain::toPlain)
                .filter(line -> !line.isEmpty())
                .collect(Collectors.joining("\n"));
    }

    public static String toPlain(Map<String, Object> diff) {
        var builder = new StringBuilder();
        String type = (String) diff.get("type");
        switch (type) {
            case "updated" -> builder
                    .append("Property '")
                    .append(diff.get("name"))
                    .append("' was updated. From ")
                    .append(stringifyValue(diff.get("oldValue")))
                    .append(" to ")
                    .append(stringifyValue(diff.get("newValue")));
            case "removed" -> builder
                    .append("Property '")
                    .append(diff.get("name"))
                    .append("' was removed");
            case "added" -> builder
                    .append("Property '")
                    .append(diff.get("name"))
                    .append("' was added with value: ")
                    .append(stringifyValue(diff.get("addedValue")));
            default -> {
            }
        }
        return builder.toString();
    }

    public static String stringifyValue(Object obj) {
        if (obj == null) {
            return "null";
        } else if (obj instanceof String) {
            return "'" + obj + "'";
        } else if (obj instanceof Number || obj instanceof Boolean) {
            return String.valueOf(obj);
        } else {
            return "[complex value]";
        }
    }
}
