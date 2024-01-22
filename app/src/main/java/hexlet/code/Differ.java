package hexlet.code;

import java.util.Map;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.TreeSet;
import java.util.TreeMap;

public class Differ {

    public static String generate(String filePath1, String filePath2) 
            throws Exception {
        String fileData1 = new String(Files.readAllBytes(Path.of(filePath1)));
        String fileData2 = new String(Files.readAllBytes(Path.of(filePath2)));
        var fileMap1 = Parser.parse(fileData1);
        var fileMap2 = Parser.parse(fileData2);

        var allKeys = new TreeSet<String>();
        allKeys.addAll(fileMap1.keySet());
        allKeys.addAll(fileMap2.keySet());
        var diff = new StringBuilder("{\n");
        for (var key : allKeys) {
            var value1 = fileMap1.get(key);
            var value2 = fileMap2.get(key);
            if (value1 == null) {
                diff.append("  + ").append(key).append(": ").append(value2).append("\n");
            } else if (value2 == null) {
                diff.append("  - ").append(key).append(": ").append(value1).append("\n");
            } else if (value1.equals(value2)) {
                diff.append("    ").append(key).append(": ").append(value1).append("\n");
            } else {
                diff.append("  - ").append(key).append(": ").append(value1).append("\n");
                diff.append("  + ").append(key).append(": ").append(value2).append("\n");
            }
        }
        diff.append("}");

        return diff.toString();
    }
}
