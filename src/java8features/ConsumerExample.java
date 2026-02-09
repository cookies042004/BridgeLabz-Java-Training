package java8features;

import java.util.*;
import java.util.function.Consumer;

public class ConsumerExample {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("amit", "rahul", "sita");

        Consumer<String> printUpper = s -> System.out.println(s.toUpperCase());

        names.forEach(printUpper);
    }
}

