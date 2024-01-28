package hexlet.code;

import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.nio.file.Files;
import java.nio.file.Path;

public class Differ {

    public static String generate(String filePath1, String filePath2, String formatType)
            throws Exception {
        var fileData1 = new String(Files.readAllBytes(Path.of(filePath1)));
        var fileData2 = new String(Files.readAllBytes(Path.of(filePath2)));

        var fileType1 = filePath1.split("\\.")[filePath1.split("\\.").length - 1];
        var fileType2 = filePath2.split("\\.")[filePath2.split("\\.").length - 1];

        var fileMap1 = Parser.createParser(fileType1)
            .parse(fileData1);
        var fileMap2 = Parser.createParser(fileType2)
            .parse(fileData2);

        var keys = Stream.concat(fileMap1.keySet().stream(), fileMap2.keySet().stream())
            .collect(Collectors.toSet());
        var diffList = keys.stream()
            .map(key -> Difference.getDifference(key, fileMap1, fileMap2))
            .collect(Collectors.toList());

        return Formatter.createFormatter(formatType)
            .format(diffList);
    }
}
