package functional_interface;

@FunctionalInterface
public interface Converter<A, B> {
    B converter(A a);
}
