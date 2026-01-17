package datastructures.hashmap;

import java.util.HashSet;

public class LongestConsecutiveSequence {
    static int longestSequence(int[] arr) {

        HashSet<Integer> set = new HashSet<>();
        int longest = 0;

        // Store all elements in HashSet
        for (int num : arr) {
            set.add(num);
        }

        // Check for sequence starting point
        for (int num : arr) {
            // Start only if num-1 does not exist
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int count = 1;

                // Check next consecutive numbers
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    count++;
                }

                longest = Math.max(longest, count);
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        int[] arr = {100, 4, 200, 1, 3, 2};
        System.out.println(longestSequence(arr)); // 4
    }
}

