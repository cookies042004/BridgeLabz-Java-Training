package java8features;

import java.util.*;
import java.util.stream.*;

public class SecondMostFrequentWord {
    public static void main(String[] args) {

        String text = "apple banana apple orange banana apple mango banana";

        Map<String, Long> frequency =
                Arrays.stream(text.split("\\s+"))
                        .collect(Collectors.groupingBy(
                                w -> w,
                                Collectors.counting()));

        frequency.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .skip(1)
                .findFirst()
                .ifPresent(e ->
                        System.out.println("Second Most Frequent: "
                                + e.getKey() + " -> " + e.getValue()));
    }
}

