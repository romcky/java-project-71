package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Differ {

    public static String generate(String filePath1, String filePath2)
            throws Exception {
        return generate(filePath1, filePath1, "stylish");
    }

    public static String generate(String filePath1, String filePath2, String formatType)
            throws Exception {
        var fileData1 = new String(Files.readAllBytes(
                Paths.get(filePath1).toAbsolutePath().normalize()));
        var fileData2 = new String(Files.readAllBytes(
                Paths.get(filePath2).toAbsolutePath().normalize()));

        var fileType1 = filePath1.split("\\.")[filePath1.split("\\.").length - 1];
        var fileType2 = filePath2.split("\\.")[filePath2.split("\\.").length - 1];

        var fileMap1 = Parser.parse(fileData1, fileType1);
        var fileMap2 = Parser.parse(fileData2, fileType2);

        var diffList = Difference.getDifferenceList(fileMap1, fileMap2);

        //diffList.stream().forEach(System.out::println);

        return Formatter.format(diffList, formatType);
        //return Formatter.createFormatter(formatType)
        //    .format(diffList);
    }
}
