package java8features;

import java.util.function.BiFunction;

public class BiFunctionExample {
    public static void main(String[] args) {

        BiFunction<String, String, String> concat =
                (s1, s2) -> s1 + " " + s2;

        String result = concat.apply("Hello", "World");
        System.out.println(result);
    }
}

