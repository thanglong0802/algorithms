package algorithms;

import java.util.HashMap;

public class _13_Roman_to_integer {
    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
    }
    public static int romanToInt(String s) {
        int result = 0;
        int length = s.length();
        HashMap<Character, Integer> hashMap = new HashMap() {{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};
        for (int i = 0; i < length; i++) {
            if (i < length - 1 && hashMap.get(s.charAt(i)) < hashMap.get(s.charAt(i + 1))) {
                result -= hashMap.get(s.charAt(i));
            } else {
                result += hashMap.get(s.charAt(i));
            }
        }

        return result;
    }
}
