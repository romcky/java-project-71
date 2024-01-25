package hexlet.code;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.Objects;
import java.nio.file.Files;
import java.nio.file.Path;
import org.apache.commons.collections4.CollectionUtils;

public class Differ {

    public static String generate(String filePath1, String filePath2, String formatType)
            throws Exception {
        var fileData1 = new String(Files.readAllBytes(Path.of(filePath1)));
        var fileData2 = new String(Files.readAllBytes(Path.of(filePath2)));

        var fileType1 = filePath1.split("\\.")[filePath1.split("\\.").length - 1];
        var fileType2 = filePath2.split("\\.")[filePath2.split("\\.").length - 1];

        var fileMap1 = Parser.createParser(fileType1).parse(fileData1);
        var fileMap2 = Parser.createParser(fileType2).parse(fileData2);

        var diffList = CollectionUtils.union(fileMap1.keySet(), fileMap2.keySet()).stream()
            .map(key -> getDifference(key, fileMap1, fileMap2))
            .collect(Collectors.toList());

        return Formatter.createFormatter(formatType).format(diffList);
    }

    private static Difference
            getDifference(String key, Map<String, Object> map1, Map<String, Object> map2) {
        if (!map1.containsKey(key)) {
            return new Difference("added", key, map2.get(key));
        } else if (!map2.containsKey(key)) {
            return new Difference("removed", key, map1.get(key));
        } else if (Objects.equals(map1.get(key), map2.get(key))) {
            return new Difference("unchanged", key, map1.get(key), map2.get(key));
        } else {
            return new Difference("updated", key, map1.get(key), map2.get(key));
        }
    }
}
