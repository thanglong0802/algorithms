package baitap;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class JavaNangCao_P1_B7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap duong dan file: ");
        String filePath = scanner.nextLine();
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                file.createNewFile();
            }
            System.out.println("Nhap vao doan van ban: ");
            String output = scanner.nextLine();
            try (
                FileOutputStream fos = new FileOutputStream(file);
                FileInputStream fis = new FileInputStream(file)
            ) {
                fos.write(output.getBytes());
                byte[] outputData = new byte[output.length()];
                fis.read(outputData);
                System.out.println(new String(outputData));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
