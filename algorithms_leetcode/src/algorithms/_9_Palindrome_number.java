package algorithms;

public class _9_Palindrome_number {
    public static void main(String[] args) {
        System.out.println(isPalindrome(12456421));
    }
    public static boolean isPalindrome(int x) {
        if (x < 10 || (x % 10 == 0 && x != 0)) return false;
        int surplus = 0;
        int result = 0;
        int xs = x;
        while (x > 0) {
            surplus = x % 10;
            x /= 10;
            result = result * 10 + surplus;
        }
        if (result != xs) return false;

        return true;
    }
}
