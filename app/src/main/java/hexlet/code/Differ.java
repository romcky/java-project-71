package hexlet.code;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.TreeSet;
import java.nio.file.Files;
import java.nio.file.Path;

public class Differ {

    public static String generate(String filePath1, String filePath2, String formatType)
            throws Exception {
        String fileData1 = new String(Files.readAllBytes(Path.of(filePath1)));
        String fileData2 = new String(Files.readAllBytes(Path.of(filePath2)));

        var fileType1 = filePath1.split("\\.")[filePath1.split("\\.").length - 1];
        var fileType2 = filePath2.split("\\.")[filePath2.split("\\.").length - 1];

        var fileMap1 = Parser.createParser(fileType1).parse(fileData1);
        var fileMap2 = Parser.createParser(fileType2).parse(fileData2);

        var diff = getDiff(fileMap1, fileMap2);

        return Formatter.createFormatter(formatType).format(diff);
    }

    private static Map<String, Object> getDiff(Map<String, Object> map1, Map<String, Object> map2) {
        var keys = new TreeSet<String>();
        keys.addAll(map1.keySet());
        keys.addAll(map2.keySet());
        var diff = new LinkedHashMap<String, Object>();
        for (var key : keys) {
            if (!map1.containsKey(key)) {
                diff.put("+ " + key, map2.get(key));
            } else if (!map2.containsKey(key)) {
                diff.put("- " + key, map1.get(key));
            } else if (Objects.equals(map1.get(key), map2.get(key))) {
                diff.put("  " + key, map1.get(key));
            } else {
                diff.put("- " + key, map1.get(key));
                diff.put("+ " + key, map2.get(key));
            }
        }
        return diff;
    }
}
