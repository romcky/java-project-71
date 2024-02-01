package hexlet.code.formatters;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Stylish {

    public static String format(List<Map<String, Object>> diffList) {
        //diffList.forEach(System.out::println);
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
/*
    @Override
    public String format(List<Difference> diffList) {
        return "{\n" + diffList.stream()
            .sorted(Comparator.comparing(Difference::getName))
            .map(this::toPlain)
            .filter(str -> !str.isEmpty())
            .collect(Collectors.joining("\n")) + "\n}";
    }
    public String toPlain(Difference diff) {
        switch (diff.getType()) {
            case Difference.UPDATED:
                return "  - " + diff.getName() + ": " + diff.getOldValue()
                    + "\n  + " + diff.getName() + ": " + diff.getNewValue();
            case Difference.UNCHANGED:
                return "    " + diff.getName() + ": " + diff.getOldValue();
            case Difference.REMOVED:
                return  "  - " + diff.getName() + ": " + diff.getOldValue();
            case Difference.ADDED:
                return "  + " + diff.getName() + ": " + diff.getNewValue();
            default:
                return "";
        }
    }

 */
}
