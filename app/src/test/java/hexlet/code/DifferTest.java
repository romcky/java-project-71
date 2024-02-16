package hexlet.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;

class DifferTest {
    private final String jsonFile1 = "src/test/resources/file1.json";
    private final String jsonFile2 = "src/test/resources/file2.json";
    private final String ymlFile1 = "src/test/resources/file1.yml";
    private final String ymlFile2 = "src/test/resources/file2.yml";
    private final String stylishExpected = getFileData("src/test/resources/diff.stylish");
    private final String plainExpected = getFileData("src/test/resources/diff.plain");
    private String jsonExpected = getFileData("src/test/resources/diff.json");

    @BeforeEach
    public void formatJsonExpected() {
        try {
            // Теперь diff.json может быть читабельно форматирован
            var tmp = new JsonMapper().readValue(jsonExpected, new TypeReference<List<Map<String, Object>>>() { });
            jsonExpected = new ObjectMapper().writeValueAsString(tmp);
        } catch (Exception e) {
            throw new RuntimeException();
        }

    }

    @Test
    public void testGenerate() {
        try {
            String result = Differ.generate(jsonFile1, jsonFile2);
            Assertions.assertEquals(result, stylishExpected);

            result = Differ.generate(jsonFile1, jsonFile2, "plain");
            Assertions.assertEquals(result, plainExpected);

            result = Differ.generate(jsonFile1, jsonFile2, "json");
            Assertions.assertEquals(result, jsonExpected);

            result = Differ.generate(ymlFile1, ymlFile2);
            Assertions.assertEquals(result, stylishExpected);

            result = Differ.generate(ymlFile1, ymlFile2, "plain");
            Assertions.assertEquals(result, plainExpected);

            result = Differ.generate(ymlFile1, ymlFile2, "json");
            Assertions.assertEquals(result, jsonExpected);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public static String getFileData(String fileName) {
        try {
            return Files.readString(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

}
