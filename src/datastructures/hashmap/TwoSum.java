package datastructures.hashmap;

import java.util.HashMap;

public class TwoSum {
    static int[] twoSum(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int needed = target - arr[i];

            // Check if required number exists
            if (map.containsKey(needed)) {
                return new int[]{map.get(needed), i};
            }

            // Store number with its index
            map.put(arr[i], i);
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int target = 9;

        int[] result = twoSum(arr, target);
        System.out.println(result[0] + " " + result[1]); // 0 1
    }
}

