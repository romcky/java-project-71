package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

class DifferTest {
    private final String jsonFile1 = "src/test/resources/file1.json";
    private final String jsonFile2 = "src/test/resources/file2.json";
    private final String ymlFile1 = "src/test/resources/file1.yml";
    private final String ymlFile2 = "src/test/resources/file2.yml";
    private final String diffFileStylish = "src/test/resources/diff.stylish";
    private final String diffFilePlain = "src/test/resources/diff.plain";
    private final String diffFileJson = "src/test/resources/diff.json";

    @Test
    public void testGenerateJSONStylish() {
        try {
            Assertions.assertEquals(
                    Differ.generate(jsonFile1, jsonFile2),
                    Files.readString(Path.of(diffFileStylish))
            );
            Assertions.assertEquals(
                    Differ.generate(jsonFile1, jsonFile2, "plain"),
                    Files.readString(Path.of(diffFilePlain))
            );
            Assertions.assertEquals(
                    Differ.generate(jsonFile1, jsonFile2, "json"),
                    Files.readString(Path.of(diffFileJson))
            );
            Assertions.assertEquals(
                    Differ.generate(ymlFile1, ymlFile2),
                    Files.readString(Path.of(diffFileStylish))
            );
            Assertions.assertEquals(
                    Differ.generate(ymlFile1, ymlFile2, "plain"),
                    Files.readString(Path.of(diffFilePlain))
            );
            Assertions.assertEquals(
                    Differ.generate(ymlFile1, ymlFile2, "json"),
                    Files.readString(Path.of(diffFileJson))
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
