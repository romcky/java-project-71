package hexlet.code.formatters;

import hexlet.code.Difference;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Comparator;

public class Plain implements DifferenceFormatter {

    @Override
    public String format(List<Difference> diffList) {
        return diffList.stream()
            .sorted(Comparator.comparing(Difference::getName))
            .map(this::toPlain)
            .filter(str -> !str.isEmpty())
            .collect(Collectors.joining("\n"));
    }

    public String toPlain(Difference diff) {
        switch (diff.getType()) {
            case Difference.UPDATED:
                return "Property '" + diff.getName() + "' was updated. From "
                    + formatValue(diff.getOldValue()) + " to " + formatValue(diff.getNewValue());
            case Difference.REMOVED:
                return  "Property '" + diff.getName() + "' was removed";
            case Difference.ADDED:
                return "Property '" + diff.getName() + "' was added with value: "
                    + formatValue(diff.getNewValue());
            default:
                return "";
        }
    }

    private String formatValue(Object obj) {
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
