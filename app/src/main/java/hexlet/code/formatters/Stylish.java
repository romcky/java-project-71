package hexlet.code.formatters;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Stylish {
    private static final int MARKERSPACES = 2;

    public static String format(List<Map<String, Object>> diffList) {
        var lines = diffList.stream()
                .map(Stylish::toStylish)
                .filter(line -> !line.isEmpty())
                .collect(Collectors.joining("\n"));
        return "{\n" + lines + "\n}";
    }

    private static String toStylish(Map<String, Object> diff) {
        var builder = new StringBuilder();
        String type = (String) diff.get("type");
        switch (type) {
            case "updated" -> builder
                    .append(wrapMarker("-", MARKERSPACES))
                    .append(diff.get("name"))
                    .append(": ")
                    .append(diff.get("oldValue"))
                    .append("\n")
                    .append(wrapMarker("+", MARKERSPACES))
                    .append(diff.get("name"))
                    .append(": ")
                    .append(diff.get("newValue"));
            case "unchanged" -> builder
                    .append(wrapMarker(" ", MARKERSPACES))
                    .append(diff.get("name"))
                    .append(": ")
                    .append(diff.get("unchangedValue"));
            case "removed" -> builder
                    .append(wrapMarker("-", MARKERSPACES))
                    .append(diff.get("name"))
                    .append(": ")
                    .append(diff.get("removedValue"));
            case "added" -> builder
                    .append(wrapMarker("+", MARKERSPACES))
                    .append(diff.get("name"))
                    .append(": ")
                    .append(diff.get("addedValue"));
            default -> throw new RuntimeException();
        }
        return builder.toString();
    }

    private static String wrapMarker(String marker, int n) {
        return " ".repeat(n) + marker + " ";
    }
}
