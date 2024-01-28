package hexlet.code;

import hexlet.code.formatters.DifferenceFormatter;
import hexlet.code.formatters.Stylish;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Json;

public final class Formatter {

    public static DifferenceFormatter createFormatter(String type) {
        switch (type.toLowerCase()) {
            case "stylish":
                return new Stylish();
            case "plain":
                return new Plain();
            case "json":
                return new Json();
            default:
                throw new IllegalArgumentException("Unknown formatter type: " + type);
        }
    }
}
