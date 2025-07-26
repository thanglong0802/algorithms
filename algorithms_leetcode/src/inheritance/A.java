package inheritance;

public class A extends B {
    private String abc;
    private String cdf;

    public A() {

    }

    public A(String abc, String cdf) {
        this.abc = abc;
        this.cdf = cdf;
    }

    public A(String cc, String abc, String cdf) {
        super(cc);
        this.abc = abc;
        this.cdf = cdf;
    }

    public String getAbc() {
        return abc;
    }

    public void setAbc(String abc) {
        this.abc = abc;
    }

    public String getCdf() {
        return cdf;
    }

    public void setCdf(String cdf) {
        this.cdf = cdf;
    }

    @Override
    public String toString() {
        return "A{" +
                "abc='" + abc + '\'' +
                ", cdf='" + cdf + '\'' +
                '}';
    }
}
