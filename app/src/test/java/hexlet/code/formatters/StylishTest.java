package hexlet.code.formatters;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Map;

public class StylishTest {

    @Test
    public void testToStylish() {
        Assertions.assertEquals(
                Stylish.toStylish(Map.of("type", "unchanged", "name", "age", "unchangedValue", 50)),
                "    age: 50"
        );
        Assertions.assertEquals(
                Stylish.toStylish(Map.of("type", "added", "name", "isEditable", "addedValue", true)),
                "  + isEditable: true"
        );
        Assertions.assertEquals(
                Stylish.toStylish(Map.of("type", "removed", "name", "pi", "removedValue", 3.14)),
                "  - pi: 3.14"
        );
        Assertions.assertEquals(
                Stylish.toStylish(Map.of()),
                ""
        );
    }
}
