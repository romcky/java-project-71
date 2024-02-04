package hexlet.code.formatters;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Stylish {

    public static String format(List<Map<String, Object>> diffList) {
        var lines = diffList.stream()
                .map(Stylish::toStylish)
                .filter(line -> !line.isEmpty())
                .collect(Collectors.joining("\n"));
        return "{\n" + lines + "\n}";
    }

    public static String toStylish(Map<String, Object> diff) {
        if ("updated".equals(diff.get("type"))) {
            return "  - " + diff.get("name") + ": " + diff.get("oldValue") + "\n"
                + "  + " + diff.get("name") + ": " + diff.get("newValue");
        } else if ("unchanged".equals(diff.get("type"))) {
            return "    " + diff.get("name") + ": " + diff.get("unchangedValue");
        } else if ("removed".equals(diff.get("type"))) {
            return "  - " + diff.get("name") + ": " + diff.get("removedValue");
        } else if ("added".equals(diff.get("type"))) {
            return "  + " + diff.get("name") + ": " + diff.get("addedValue");
        } else {
            return "";
        }
    }
}
