package hexlet.code.formatters;

import hexlet.code.Difference;

public class Plain implements DifferenceFormatter {

    @Override
    public String formatDifference(Difference diff) {
        switch (diff.getInfo()) {
            case "updated":
                return "Property '" + diff.getName() + "' was updated. From "
                    + formatValue(diff.getOldValue()) + " to " + formatValue(diff.getNewValue());
            case "removed":
                return  "Property '" + diff.getName() + "' was removed";
            case "added":
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
