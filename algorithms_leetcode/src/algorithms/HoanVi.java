package algorithms;

import java.util.Arrays;

public class HoanVi {
    public static void main(String[] args) {
        String ori = "abc";
        String hoanViOfOri = "bac";
        if (ori.length() != hoanViOfOri.length()) {
            System.out.println("Khong phai hoan vi 1");
            return;
        }
        boolean isHoanVi = hoanVi(ori, hoanViOfOri);
        if (isHoanVi)
            System.out.println("La hoan vi");
        else
            System.out.println("Khong phai hoan vi");
//        hoanViUsingCollection(ori, hoanViOfOri);
    }
    private static boolean hoanVi(String ori, String hoanVi) {
        boolean isHoanVi = false;
        for (int i = 0; i < ori.length(); i++) {
            for (int j = 0; j < hoanVi.length(); j++) {
                if (ori.charAt(i) == hoanVi.charAt(j)) {
                    isHoanVi = true;
                    break;
                }
            }
            if (!isHoanVi) {
                return false;
            }
        }
        return true;
    }

    private static boolean hoanViUsingCollection(String ori, String hoanVi) {
        char[] oriChar = ori.toCharArray();
        char[] hoanViChar = hoanVi.toCharArray();
        Arrays.sort(oriChar);
        Arrays.sort(hoanViChar);
        boolean isHoanVi = Arrays.toString(oriChar).equals(Arrays.toString(hoanViChar));
        if (isHoanVi) {
            System.out.println("La hoan vi");
        } else {
            System.out.println("Khong phai hoan vi");
            return false;
        }
        return true;
    }
}
