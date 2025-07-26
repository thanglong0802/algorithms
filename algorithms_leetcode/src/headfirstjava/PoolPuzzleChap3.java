package headfirstjava;

public class PoolPuzzleChap3 {
    double area;
    int height;
    int length;
    boolean aBooleanDefault;
    String stringDefault;
    char aCharDefault = 0;

    public static void main(String[] args) {
        PoolPuzzleChap3 test = new PoolPuzzleChap3();
        System.out.println(test.area);
        System.out.println(test.height);
        System.out.println(test.aBooleanDefault);
        System.out.println(test.stringDefault);
        System.out.println(test.aCharDefault);

        int x = 0;
        PoolPuzzleChap3 [] ta = new PoolPuzzleChap3[4];
        while (x < 4) {
            ta[x] = new PoolPuzzleChap3();
            ta[x].height = (x + 1) * 2;
            ta[x].length = x + 4;
            ta[x].setArea();
            System.out.print("triangle " + x + ", area");
            System.out.println(" = " + ta[x].area);
            x += 1;
        }
        int y = x;
        x = 27;
        PoolPuzzleChap3 t5 = ta[2];
        ta[2].area = 343;
        System.out.print("y = " + y);
        System.out.println(", t5 area = " + t5.area);
    }

    void setArea() {
        /*
        * CT tính diện tích hình tam giác thường biết:
        * height: là chiều cao
        * length: độ dài đáy
        * area: diện tích
        * area = (length * height) / 2
        */
        area = (height * length) / 2;
    }
}
