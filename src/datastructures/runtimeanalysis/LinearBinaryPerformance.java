package datastructures.runtimeanalysis;

public class LinearBinaryPerformance {
    // Linear Search
    static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    // Binary Search
    static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target)
                return mid;
            else if (arr[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }

    // Run benchmark
    static void runTest(int size) {

        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i;
        }

        int target = size - 1; // Worst case

        // linear search
        long startLinear = System.nanoTime();
        linearSearch(arr, target);
        long endLinear = System.nanoTime();

        // binary search
        long startBinary = System.nanoTime();
        binarySearch(arr, target);
        long endBinary = System.nanoTime();

        System.out.println("Dataset size: " + size);
        System.out.println("Linear Search Time  : " + (endLinear - startLinear) + " ns");
        System.out.println("Binary Search Time  : " + (endBinary - startBinary) + " ns");
        System.out.println("--------------------------------------");
    }

    public static void main(String[] args) {
        int[] sizes = {10, 100, 1_000, 10_000, 100_000, 1_000_000};

        for (int size : sizes) {
            runTest(size);
        }
    }
}

