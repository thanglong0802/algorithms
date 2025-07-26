package functional_interface;

import java.util.logging.Logger;

public class SingleAbstractMethodImpl {
    private static final Logger logger = Logger.getLogger("SingleAbstractMethodImpl");

    private int id;
    private String name;
    private float price;

    public SingleAbstractMethodImpl() {
    }

    public SingleAbstractMethodImpl(int id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    /*public static void main(String[] args) {
        // Ví dụ khi không sử dụng Lambda và có sử dụng lambda.
        List<String> languages = Arrays.asList("Java", "C#", "C++", "PHP", "Javascript");
        languages.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println(languages);

        List<String> languagex = Arrays.asList("B5", "B4", "B1", "B3", "Javascript");
        languagex.sort((o1, o2) -> o1.compareTo(o2));
        System.out.println(languagex);
    }*/

    /*public static void main(String[] args) {
        SingleAbstractMethod singleAbstractMethod = () -> "Functional Interface không có tham số";
        SingleAbstractMethod singleAbstractMethod1 = new SingleAbstractMethod() {
            @Override
            public String functionalInterfaceChiCoDuyNhatMotMethod() {
                return "Sử dụng lớp bên trong ẩn danh";
            }
        };
        singleAbstractMethod.defaultMethod1();
        singleAbstractMethod.defaultMethod2();
        SingleAbstractMethod.staticMethod();
        logger.info(singleAbstractMethod.functionalInterfaceChiCoDuyNhatMotMethod());
        logger.info(singleAbstractMethod1.functionalInterfaceChiCoDuyNhatMotMethod());
    }*/

    /*public static void main(String[] args) {
        List<SingleAbstractMethodImpl> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new SingleAbstractMethodImpl(i, "Ten toi la " + i, 30000f + i));
        }
        Stream<SingleAbstractMethodImpl> dataFilter = list.stream().filter(p -> p.id > 5);
        dataFilter.forEach(p -> logger.log(Level.INFO, "ID: " + p.getId() + ", Name: " + p.getName() + ", price: " + p.getPrice()));
    }*/

    // Phạm vi truy cập biến local
    public static void doSomeThing1() {
        final int num = 1;
        Converter<Integer, String> converter = new Converter<Integer, String>() {
            @Override
            public String converter(Integer integer) {
                return String.valueOf(integer + num);
            }
        };
        logger.info(converter.converter(2));
    }

    public static void doSomeThing2() {
        int num = 1;
        Converter<Integer, String> converter = (form) -> String.valueOf(form + num);
        logger.info(converter.converter(2));
    }

    public static void doSomeThing3() {
        int num = 1;
        Converter<Integer, String> converter = (form) -> String.valueOf(form + num);
        logger.info(converter.converter(2));
    }
    
    public static void main(String[] args) {
        doSomeThing1();
        doSomeThing2();
        doSomeThing3();
    }

}
