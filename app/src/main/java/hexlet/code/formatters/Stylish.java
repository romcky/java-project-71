package hexlet.code.formatters;

import hexlet.code.Difference;
import java.util.List;

public class Stylish implements DifferenceFormatter {

    @Override
    public String formatDifference(Difference diff) {
        switch (diff.getInfo()) {
            case "updated":
                return "  - " + diff.getName() + ": " + diff.getOldValue()
                    + "\n  + " + diff.getName() + ": " + diff.getNewValue();
            case "unchanged":
                return "    " + diff.getName() + ": " + diff.getOldValue();
            case "removed":
                return  "  - " + diff.getName() + ": " + diff.getOldValue();
            case "added":
                return "  + " + diff.getName() + ": " + diff.getNewValue();
            default:
                return "";
        }
    }

    @Override
    public String format(List<Difference> diffList) {
        return "{\n" + DifferenceFormatter.super.format(diffList) + "\n}";
    }
}
