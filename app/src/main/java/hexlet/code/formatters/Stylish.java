package hexlet.code.formatters;

import hexlet.code.Difference;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Comparator;

public class Stylish implements DifferenceFormatter {

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
}
