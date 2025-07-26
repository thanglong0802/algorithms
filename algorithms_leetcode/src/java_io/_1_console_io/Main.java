package _1_console_io;

import java.io.*;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        try (InputStream inputStream = new FileInputStream(Paths.get("folderNew").resolve("fileTest.txt").toString())) {
            System.out.println(readFromInputStream(inputStream));
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private static String readFromInputStream(InputStream inputStream) {
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return resultStringBuilder.toString();
    }

}
