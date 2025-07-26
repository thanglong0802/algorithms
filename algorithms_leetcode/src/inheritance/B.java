package inheritance;

public class B {
    private String cc;

    public B() {

    }

    public B(String cc) {
        this.cc = cc;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    @Override
    public String toString() {
        return "B{" +
                "cc='" + cc + '\'' +
                '}';
    }
}
