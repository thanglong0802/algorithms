package common;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CommonUtils {
    private static final Logger LOGGER = Logger.getLogger("CommonUtils");
    private static String openSource = "yes";
    public static String padLeft(int totalWidth, char paddingChar, char startWith, String value) {
        StringBuilder result = new StringBuilder();
        if (totalWidth <= 0) {
            throw new IllegalArgumentException(totalWidth + " tổng chiều rộng phải lớn hơn hoặc bằng 1");
        }
        if (paddingChar == ' ') {
            paddingChar = '0';
        }
        if (totalWidth == value.length()) {
            return value;
        } else if (totalWidth < value.length()) {
            throw new IllegalArgumentException("Tổng chiều rộng không được nhỏ hơn giá trị");
        } else {
            int paddingLeft = Math.max(0, (totalWidth - 1) - value.length());
            result.append(String.valueOf(paddingChar).repeat(paddingLeft));
        }
        result.append(value);
        result.insert(0, startWith);
        return result.toString();
    }

    public static boolean isNotNull(String value) {
        return value != null;
    }

    public static boolean isNullOrEmpty(String value) {
        return value == null || value.isEmpty();
    }

    public static boolean compareValue(String value1, String value2) {
        if (isNotNull(value1) && isNotNull(value2)) {
            return value1.equals(value2);
        }
        return false;
    }

    static {
        System.out.println("Khoi status run");
        openSource = "no";
        LOGGER.log(Level.INFO, "{line 47: }" + openSource);
    }

    public static void main(String[] args) {
        System.out.println("line 51: " + openSource);
        for (int i = 1; i <= 20; i++) {
            String warehouseCode = padLeft(9, ' ', 'A', String.valueOf(i));
            LOGGER.log(Level.INFO, String.format("Mã kho: %s", warehouseCode));
        }
        var isEqual = compareValue("", "");
        var arr = new ArrayList<String>();
        arr.add("s1");
        arr.add("s1");
        arr.add("s2");
        System.out.println(isEqual);
        System.out.println(arr.stream().distinct().count());
    }
}
