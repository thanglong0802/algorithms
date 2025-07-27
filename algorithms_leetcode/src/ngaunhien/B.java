package ngaunhien;

public class B extends A {
    private String bcd;

    public B() {
        super("abc");
    }

    public B(String bcd) {
        super("abc");
        this.bcd = bcd;
    }

    public String getBcd() {
        return bcd;
    }

    public void setBcd(String bcd) {
        this.bcd = bcd;
    }
}
