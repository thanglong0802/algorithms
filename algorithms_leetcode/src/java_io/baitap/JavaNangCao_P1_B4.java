package baitap;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class JavaNangCao_P1_B4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập đường dẫn file: ");
        String filePath = scanner.nextLine();
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                file.createNewFile();
                System.out.println("Created File Success");
            }
            System.out.println("Nhap noi dung can them vao file: ");
            String output = scanner.nextLine();
            RandomAccessFile raf = new RandomAccessFile(filePath, "rw");
//            raf.writeUTF(output);
            raf.writeBytes(output);
            raf.seek(0);
//            System.out.println("Noi dung cua file: " + raf.readUTF());
            System.out.println("Noi dung cua file: " + raf.readLine());
            raf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
