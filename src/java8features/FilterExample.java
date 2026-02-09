package java8features;

import java.util.*;

public class FilterExample {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("Amit", "Rahul", "Ankit", "Suresh", "Ajay");

        names.stream()
                .filter(name -> name.startsWith("A"))
                .forEach(System.out::println);
    }
}

