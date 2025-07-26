package learn_stream_api_java8;

public class StringAndStringBuffer {
    private static void string() {
        long start = System.nanoTime();
        String a = "a";
        for (int i = 0; i < 1000; i++) {
            a += "b";
        }
        long end = System.nanoTime();
        System.out.println("Total time: " + (end - start));
    }

    private static void stringBuffer() {
        long start = System.nanoTime();
        StringBuffer a = new StringBuffer("a");
        for (int i = 0; i < 1000; i++) {
            a.append("b");
        }
        long end = System.nanoTime();
        System.out.println("Total time: " + (end - start));
    }

    private static void stringBuilder() {
        long start = System.nanoTime();
        StringBuilder a = new StringBuilder("a");
        for (int i = 0; i < 1000; i++) {
            a.append("b");
        }
        long end = System.nanoTime();
        System.out.println("Total time: " + (end - start));
    }

    public static void main(String[] args) {
        string();
        stringBuffer();
        stringBuilder();
    }

}
