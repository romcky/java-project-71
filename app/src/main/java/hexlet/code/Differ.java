package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Differ {

    public static String generate(String filePath1, String filePath2)
            throws Exception {
        return generate(filePath1, filePath2, "stylish");
    }

    public static String generate(String fileName1, String fileName2, String formatType)
            throws Exception {
        var fileData1 = Files.readString(getPath(fileName1));
        var fileData2 = Files.readString(getPath(fileName2));

        var fileExtension1 = getFileExtension(fileName1);
        var fileExtension2 = getFileExtension(fileName2);

        var fileMap1 = Parser.parse(fileData1, fileExtension1);
        var fileMap2 = Parser.parse(fileData2, fileExtension2);

        var diffList = Difference.getDifferenceList(fileMap1, fileMap2);

        return Formatter.format(diffList, formatType);
    }

    private static Path getPath(String fileName) {
        return Paths.get(fileName).toAbsolutePath().normalize();
    }

    private static String getFileExtension(String fileName) {
        return fileName.split("\\.")[fileName.split("\\.").length - 1];
    }
}
