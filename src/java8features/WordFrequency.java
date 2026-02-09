package java8features;

import java.util.*;
import java.util.stream.*;

public class WordFrequency {
    public static void main(String[] args) {

        String text = "Java is great. Java is powerful. Java streams are powerful and great.";

        int N = 3;

        Map<String, Long> frequency =
                Arrays.stream(text.toLowerCase()
                                .replaceAll("[^a-z ]", "")
                                .split("\\s+"))
                        .collect(Collectors.groupingBy(
                                w -> w,
                                Collectors.counting()));

        frequency.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(N)
                .forEach(e ->
                        System.out.println(e.getKey() + " -> " + e.getValue()));
    }
}

