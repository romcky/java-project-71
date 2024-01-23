package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

class DifferTest {

    @Test
    public void testGenerate() {
        try {
            String result = Differ.generate("file1.json", "file2.json");
            String expected = new String(Files.readAllBytes(Path.of("diff-1-2.stylish")));
            Assertions.assertEquals(result, expected);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
