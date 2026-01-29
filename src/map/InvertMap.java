package map;

import java.util.*;

public class InvertMap {
    public static void main(String[] args) {
        Map<String, Integer> map = Map.of("A", 1, "B", 2, "C", 1);
        Map<Integer, List<String>> result = new HashMap<>();

        for (String key : map.keySet()) {
            result
                    .computeIfAbsent(map.get(key), k -> new ArrayList<>())
                    .add(key);
        }
        System.out.println(result);
    }
}

