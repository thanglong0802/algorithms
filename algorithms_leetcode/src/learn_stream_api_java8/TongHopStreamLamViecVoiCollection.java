package learn_stream_api_java8;

import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TongHopStreamLamViecVoiCollection {
    private static final Logger LOGGER = Logger.getLogger("TongHopStreamLamViecVoiCollection");
    public static void main(String[] args) {
        List<Object> listData = Arrays.asList("Nguyen Thang Long", "Ho Huu Quang", "Le Dang Quang");
        listData.stream()
                .map(item -> item + " OOP")
                .map(String::toUpperCase)
                .forEach(System.out::println);
        for (Object item: listData) {
            System.out.println(item);
        }

        List<Integer> integerList = IntStream.range(1, 1000).boxed()
                .filter(item -> item % 2 == 0)
                .limit(10)
                .collect(Collectors.toList());
        System.out.println(Arrays.toString(integerList.toArray()));

        Stream<String> stream = Stream.of("hehe", ".", "liko").filter(item -> item.contains("e"));
//        System.out.println(Arrays.toString(stream.toArray()));
//        Optional<String> anyElement = stream.findAny();
        Optional<String> firstElement = stream.findFirst();
        System.out.println(firstElement);
    }
}
