package headfirstjava;

class Echo {
    int count = 0;
    void hello() {
        System.out.println("helloooo...");
    }
}

public class PoolPuzzlePage44 {
    public static void main(String[] args) {
        Echo e1 = new Echo();
        Echo e2;
        e2 = e1;
        System.out.println(e1);
        System.out.println(e2);
        int x = 0;
        while (x < 4) { // x == 0, 1, 2, 3,
            e1.hello();
            e1.count = e1.count + 1; //1, 2, 3, 4,
            if (x == 3) {
                e2.count = e2.count + 1; // e2 == 6,
            }
            if (x > 0) {
                e2.count = e2.count + e1.count; // e2 == 2, 5, 10
            }

            x = x + 1;
        }
        System.out.println(e2.count);
    }
}
