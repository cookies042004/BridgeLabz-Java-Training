package map;

import java.util.HashMap;
import java.util.Map;

public class MaxValueInMap {
    public static void main(String[] args) {

        // Input map
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 10);
        map.put("B", 20);
        map.put("C", 15);

        String maxKey = null;
        int maxValue = Integer.MIN_VALUE;

        // Traversing the map
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                maxKey = entry.getKey();
            }
        }

        System.out.println("Key with highest value: " + maxKey);
        System.out.println("Highest value: " + maxValue);
    }
}

