package functional_interface;

import java.util.logging.Logger;

@FunctionalInterface
public interface SingleAbstractMethod {
    Logger logger = Logger.getLogger("SingleAbstractMethod");
    String functionalInterfaceChiCoDuyNhatMotMethod();

    default void defaultMethod1() {
        logger.info("1. Phương thức default method trong interface");
    }

    default void defaultMethod2() {
        logger.info("2. Phương thức default method trong interface");
    }

    static void staticMethod() {
        logger.info("Phương thức static method trong interface");
    }

    int hashCode();

    String toString();

    boolean equals(Object obj);
}
