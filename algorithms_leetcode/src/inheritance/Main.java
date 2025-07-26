package inheritance;

public class Main {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        a.setCc("cc of A");
        a.setAbc("abc of A");
        a.setCdf("cdf of A");

        b.setCc("cc of B");
        System.out.println(a);
        System.out.println(b);
        System.out.println("Giá trị của A: " + a.getCc());
        System.out.println("Giá trị của B: " + b.getCc());

        System.out.println(30 + 40);
        System.out.println(30 + "40");
        System.out.println(30 + "40 hello");
    }
}
