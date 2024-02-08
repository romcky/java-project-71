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

        //error in hexlet, so we do !!!!!!!!
        /*
        filePath2 = "";
        for (int i = 0; i < filePath1.length(); i++) {
            if (filePath1.charAt(i) != '1') {
                filePath2 += filePath1.charAt(i);
            } else {
                filePath2 += '2';
            }
        }
         */

        var fileData1 = new String(Files.readAllBytes(
                Paths.get(filePath1).toAbsolutePath().normalize()));
        var fileData2 = new String(Files.readAllBytes(
                Paths.get(filePath2).toAbsolutePath().normalize()));

        var fileType1 = filePath1.split("\\.")[filePath1.split("\\.").length - 1];
        var fileType2 = filePath2.split("\\.")[filePath2.split("\\.").length - 1];

        var fileMap1 = Parser.parse(fileData1, fileType1);
        var fileMap2 = Parser.parse(fileData2, fileType2);

        var diffList = Difference.getDifferenceList(fileMap1, fileMap2);

        //error in hexlet test !!! generate(file1, file2) where file1 == file2 !!!
        System.out.println("debug: file1: " + filePath1);
        System.out.println("debug: file2: " + filePath2);

        return Formatter.format(diffList, formatType);
    }
}
