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
        if ("updated".equals(diff.get("type"))) {
            return "Property '" + diff.get("name") + "' was updated. From "
                    + formatValue(diff.get("oldValue")) + " to " + formatValue(diff.get("newValue"));
        } else if ("removed".equals(diff.get("type"))) {
            return  "Property '" + diff.get("name") + "' was removed";
        } else if ("added".equals(diff.get("type"))) {
            return "Property '" + diff.get("name") + "' was added with value: "
                    + formatValue(diff.get("addedValue"));
        } else {
            return "";
        }
    }

    public static String formatValue(Object obj) {
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
