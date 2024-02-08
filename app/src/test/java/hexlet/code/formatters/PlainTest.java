package hexlet.code.formatters;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.util.List;

public class PlainTest {

    @Test
    public void testFormatValue() {
        Assertions.assertEquals(Plain.formatValue(null), "null");
        Assertions.assertEquals(Plain.formatValue("test"), "'test'");
        Assertions.assertEquals(Plain.formatValue(0), "0");
        Assertions.assertEquals(Plain.formatValue(true), "true");
        Assertions.assertEquals(Plain.formatValue(List.of()), "[complex value]");
    }
}
