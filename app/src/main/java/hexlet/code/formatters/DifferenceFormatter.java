package hexlet.code.formatters;

import hexlet.code.Difference;
import java.util.List;
import java.util.Comparator;
import java.util.stream.Collectors;

public interface DifferenceFormatter {

    default String format(List<Difference> diffList) {
        return diffList.stream()
            .sorted(Comparator.comparing(Difference::getName))
            .map(this::formatDifference)
            .filter(str -> !str.isEmpty())
            .collect(Collectors.joining("\n"));
    }

    String formatDifference(Difference diff);
}

