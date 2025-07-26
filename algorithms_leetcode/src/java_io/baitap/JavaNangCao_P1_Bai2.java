package baitap;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class JavaNangCao_P1_Bai2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap vao duong dan file: ");
        String filePath = scanner.nextLine();
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                file.createNewFile();
            } else {
                System.out.println("Kich thuoc cua file: " + file.length());
                System.out.println("Can read? " + file.canRead());
                System.out.println("Can write? " + file.canWrite());
                System.out.println("Parent folder: " + file.getParent());
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/YYYY hh:mm:ss");
                ZoneId zoneId = ZoneId.of("Asia/Ho_Chi_Minh");
                System.out.println("Last modified: " + Instant.ofEpochMilli(file.lastModified()).atZone(zoneId).format(dateTimeFormatter));
                System.out.println("================================");
                scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    String op = scanner.nextLine();
                    System.out.println(op);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
