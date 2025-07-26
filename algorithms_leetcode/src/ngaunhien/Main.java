package ngaunhien;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class Main {
    public static void main(String[] args) {
        AtomicLong dots = new AtomicLong();
        AtomicLong count = new AtomicLong();

        StringBuilder sb = new StringBuilder("Hello");
        if (dots.incrementAndGet() == 4) {
            dots.set(1);
        }

        AtomicLong idsAtomic = new AtomicLong();
        List<String> ids = new ArrayList<>();
        ids.add("a"); ids.add("b"); ids.add("c");
        ids.forEach(id -> {
            System.out.println(idsAtomic.getAndIncrement());
        });

        for (int i = 0; i < dots.get(); i++) {
            sb.append('.');
        }
        sb.append(count.incrementAndGet());
        String msg = sb.toString();
        System.out.println(msg);
    }
}
