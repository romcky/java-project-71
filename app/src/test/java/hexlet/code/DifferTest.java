package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

class DifferTest {

    @Test
    public void testGenerate() {
        try {
            String result = Differ.generate("file1.json", "file2.json", "stylish");
            String expected = new String(Files.readAllBytes(Path.of("diff-1-2")));
            Assertions.assertEquals(result, expected);

            result = Differ.generate("file3.yaml", "file4.yaml", "stylish");
            expected = new String(Files.readAllBytes(Path.of("diff-3-4")));
            Assertions.assertEquals(result, expected);

            result = Differ.generate("file5.json", "file6.json", "stylish");
            expected = new String(Files.readAllBytes(Path.of("diff-5-6")));
            Assertions.assertEquals(result, expected);

            result = Differ.generate("file7.yml", "file8.yml", "stylish");
            expected = new String(Files.readAllBytes(Path.of("diff-7-8")));
            Assertions.assertEquals(result, expected);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
