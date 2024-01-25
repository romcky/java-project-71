package hexlet.code;

import hexlet.code.formatters.DifferenceFormatter;
import hexlet.code.formatters.Stylish;
import hexlet.code.formatters.Plain;

public final class Formatter {

    public static DifferenceFormatter createFormatter(String type) {
        switch (type) {
            case "stylish":
                return new Stylish();
            case "plain":
                return new Plain();
            default:
                throw new IllegalArgumentException("Unknown formatter type: " + type);
        }
    }
}
