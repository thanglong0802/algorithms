package algorithms;

public class Recursive {
    public static void main(String[] args) {
        System.out.println(sum(8));
    }

    private static int sum(int n) {
        if (n == 1) return 1;
        if (n % 2 == 0) {
            return sum(n - 1);
        } else {
            return n + sum(n - 1);
        }
    }
}
