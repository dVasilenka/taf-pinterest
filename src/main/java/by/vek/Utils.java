package by.vek;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Utils {
    public static String readFile(String fileName) {
        String fileContent = "";
        try {
             fileContent = readResourceFile(fileName);
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
        return fileContent;
    }

    public static String readResourceFile(String filePath) throws IOException {
        try (InputStream inputStream = Utils.class.getClassLoader().getResourceAsStream(filePath);
             Scanner scanner = new Scanner(inputStream, "UTF-8")) {
            if (inputStream == null) {
                throw new IOException("Файл не найден: " + filePath);
            }
            scanner.useDelimiter("\\A"); // Читаем весь файл целиком
            return scanner.hasNext() ? scanner.next() : "";
        }
    }
}
