package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

class DifferTest {

    @Test
    public void testGenerateJSONStylish() {
        try {
            String result = Differ.generate("file5.json", "file6.json", "stylish");
            String expected = new String(Files.readAllBytes(Path.of("diff-5-6-stylish")));
            Assertions.assertEquals(result, expected);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGenerateJSONPlain() {
        try {
            String result = Differ.generate("file5.json", "file6.json", "plain");
            String expected = new String(Files.readAllBytes(Path.of("diff-5-6-plain")));
            Assertions.assertEquals(result, expected);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGenerateYMLStylish() {
        try {
            String result = Differ.generate("file7.yml", "file8.yml", "stylish");
            String expected = new String(Files.readAllBytes(Path.of("diff-7-8-stylish")));
            Assertions.assertEquals(result, expected);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGenerateYMLPlain() {
        try {
            String result = Differ.generate("file7.yml", "file8.yml", "plain");
            String expected = new String(Files.readAllBytes(Path.of("diff-7-8-plain")));
            Assertions.assertEquals(result, expected);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
