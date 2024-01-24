package hexlet.code;

import java.util.LinkedHashMap;
import java.util.Objects;
import java.util.TreeSet;
import java.nio.file.Files;
import java.nio.file.Path;

public class Differ {

    public static String generate(String filePath1, String filePath2)
            throws Exception {
        String fileData1 = new String(Files.readAllBytes(Path.of(filePath1)));
        String fileData2 = new String(Files.readAllBytes(Path.of(filePath2)));

        var fileType1 = filePath1.split("\\.")[filePath1.split("\\.").length - 1];
        var fileType2 = filePath2.split("\\.")[filePath2.split("\\.").length - 1];

        var fileMap1 = Parser.createParser(fileType1).parse(fileData1);
        var fileMap2 = Parser.createParser(fileType2).parse(fileData2);

        var allKeys = new TreeSet<String>();
        allKeys.addAll(fileMap1.keySet());
        allKeys.addAll(fileMap2.keySet());

        var diff = new LinkedHashMap<String, Object>();

        for (var key : allKeys) {
            var value1 = fileMap1.get(key);
            var value2 = fileMap2.get(key);
            if (Objects.equals(value1, value2)) {
                diff.put("  " + key, value1);
            } else if (value1 == null) {
                diff.put("+ " + key, value2);
            } else if (value2 == null) {
                diff.put("- " + key, value1);
            } else {
                diff.put("- " + key, value1);
                diff.put("+ " + key, value2);
            }
        }

        return Converter.convert(diff);
    }
}
