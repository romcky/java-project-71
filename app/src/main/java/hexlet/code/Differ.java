package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class Differ {

    public static String generate(String filePath1, String filePath2)
            throws Exception {
        return generate(filePath1, filePath2, "stylish");
    }

    public static String generate(String fileName1, String fileName2, String formatType)
            throws Exception {

        var fileMap1 = getFileMap(fileName1);
        var fileMap2 = getFileMap(fileName2);

        var diffList = Difference.getDifferenceList(fileMap1, fileMap2);

        return Formatter.format(diffList, formatType);
    }

    private static Map<String, Object> getFileMap(String fileName)
            throws Exception {
        var fileData = Files.readString(getPath(fileName));
        var fileExtension = getFileExtension(fileName);
        return Parser.parse(fileData, fileExtension);
    }

    private static Path getPath(String fileName) {
        return Paths.get(fileName).toAbsolutePath().normalize();
    }

    private static String getFileExtension(String fileName) {
        return fileName.split("\\.")[fileName.split("\\.").length - 1];
    }
}
