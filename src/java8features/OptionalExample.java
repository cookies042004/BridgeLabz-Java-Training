package java8features;

import java.util.*;

public class OptionalExample {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(10, 20, 30, 5);

        Optional<Integer> max =
                numbers.stream().max(Integer::compareTo);

        max.ifPresentOrElse(
                value -> System.out.println("Max value: " + value),
                () -> System.out.println("List is empty")
        );
    }
}
