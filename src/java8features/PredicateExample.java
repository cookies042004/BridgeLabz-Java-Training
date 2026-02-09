package java8features;

import java.util.*;
import java.util.function.Predicate;

public class PredicateExample {
    public static void main(String[] args) {

        List<String> words = Arrays.asList("Apple", "Banana", "Apricot", "Mango", "Avocado");

        Predicate<String> lengthCheck = s -> s.length() > 5;
        Predicate<String> containsA = s -> s.contains("A");

        words.stream()
                .filter(lengthCheck.and(containsA))
                .forEach(System.out::println);
    }
}

