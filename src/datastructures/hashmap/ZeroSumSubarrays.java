package datastructures.hashmap;

import java.util.*;

public class ZeroSumSubarrays {
    // Function to find all subarrays with sum = 0
    static void findZeroSumSubarrays(int[] arr) {

        // HashMap to store cumulative sum and list of indices
        Map<Integer, List<Integer>> map = new HashMap<>();

        int sum = 0;

        // Initialize with sum 0 at index -1
        map.put(0, new ArrayList<>(Arrays.asList(-1)));

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            // If same sum is already present, zero-sum subarray exists
            if (map.containsKey(sum)) {
                for (int startIndex : map.get(sum)) {
                    System.out.println("Subarray found from index "
                            + (startIndex + 1) + " to " + i);
                }
            }

            // Add current index to the map
            map.computeIfAbsent(sum, k -> new ArrayList<>()).add(i);
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, -7, 3, 1, 3, 1, -4};
        findZeroSumSubarrays(arr);
    }
}

