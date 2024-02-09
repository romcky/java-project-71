package hexlet.code.formatters;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.util.List;
import java.util.Map;

public class PlainTest {

    @Test
    public void testFormatValue() {
        Assertions.assertEquals(Plain.formatValue(null), "null");
        Assertions.assertEquals(Plain.formatValue("test"), "'test'");
        Assertions.assertEquals(Plain.formatValue(0), "0");
        Assertions.assertEquals(Plain.formatValue(true), "true");
        Assertions.assertEquals(Plain.formatValue(List.of()), "[complex value]");
    }

    @Test
    public void testToPlain() {
        Assertions.assertEquals(
                Plain.toPlain(Map.of("type", "unchanged", "name", "age", "unchangedValue", 50)),
                ""
        );
        Assertions.assertEquals(
                Plain.toPlain(Map.of("type", "added", "name", "isEditable", "addedValue", true)),
                "Property 'isEditable' was added with value: true"
        );
        Assertions.assertEquals(
                Plain.toPlain(Map.of("type", "removed", "name", "pi", "removedValue", 3.14)),
                "Property 'pi' was removed"
        );
        Assertions.assertEquals(
                Plain.toPlain(Map.of()),
                ""
        );
    }
}
