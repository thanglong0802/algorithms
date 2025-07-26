package headfirstjava.cacbaitestngaunhien;

public class Home {

    private int soNguoiTrongMotGiaDinh;
    private int soCaiGhe = 100;

    public int instanceVariable() {
        System.out.println("So nguoi trong mot gia dinh: " + this.soNguoiTrongMotGiaDinh);
        System.out.println("So cai ghe: " + this.soCaiGhe);
        return 1;
    }

    public int localVariable(Integer a, Integer b) {
        int init;
//        int total = init + 10;
//        System.out.println("Gia tri khoi tao: " + init);
//        int total = a + b;
        return 1;
    }

    public static void main(String[] args) {
        Home home = new Home();
        Home home1 = new Home();
        System.out.println(home.instanceVariable());
        System.out.println(home.localVariable(null, null));
        System.out.println("Hai doi tuong home khong bang nhau vi ca 2 la doi tuong khac nhau: " + (home == home1));
        Home home2ReferenceToHome1 = home1;
        System.out.println("Hai doi tuong home bang nhau vi cung reference den 1 gia tri tren heap: " + (home1 == home2ReferenceToHome1));
    }

}
