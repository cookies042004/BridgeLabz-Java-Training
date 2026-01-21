package datastructures.linearbinarysearch;

import java.util.Arrays;

public class LinearAndBinarySearchChallenge {
    static int firstMissingPositive(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = n + 1;
            }
        }

        for (int i = 0; i < n; i++) {
            int val = Math.abs(nums[i]);

            if (val >= 1 && val <= n) {
                nums[val - 1] = -Math.abs(nums[val - 1]);
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }

        return n + 1;
    }

    static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1};
        int target = 4;

        // Copy array because firstMissingPositive modifies it
        int[] copyForLinear = Arrays.copyOf(nums, nums.length);
        int missing = firstMissingPositive(copyForLinear);

        // Sort for binary search
        Arrays.sort(nums);
        int index = binarySearch(nums, target);

        System.out.println("First missing positive integer: " + missing);
        System.out.println("Sorted array: " + Arrays.toString(nums));
        System.out.println("Target index (binary search): " + index);
    }
}

