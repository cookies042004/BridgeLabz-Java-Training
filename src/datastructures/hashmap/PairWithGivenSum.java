package datastructures.hashmap;

import java.util.HashMap;

public class PairWithGivenSum {
    static boolean hasPair(int[] arr, int target) {

        HashMap<Integer, Boolean> map = new HashMap<>();

        for (int num : arr) {
            int needed = target - num;

            // If required number already exists, pair found
            if (map.containsKey(needed)) {
                return true;
            }

            // Store current number
            map.put(num, true);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {8, 7, 2, 5, 3, 1};
        int target = 10;

        System.out.println(hasPair(arr, target)); // true
    }
}

