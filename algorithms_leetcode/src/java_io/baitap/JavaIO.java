package baitap;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

public class JavaIO {

    public static void main(String[] args) {
        Path path = Path.of("D:\\javanangcao-javaio", "data.txt");
        File file = new File(path.toString());
        try {
            FileOutputStream fos = new FileOutputStream(file);
            String str = "Hello năm trăm anh em nhé!";
            fos.write(str.getBytes());
            fos.close();

            String content = Files.readString(path);
            System.out.println(content);

            byte[] content1 = Files.readAllBytes(path);
            System.out.println(new String(content1));

            String formatName = file.getName().substring(file.getName().length() - 4);
            System.out.println(Objects.equals(formatName, ".txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
