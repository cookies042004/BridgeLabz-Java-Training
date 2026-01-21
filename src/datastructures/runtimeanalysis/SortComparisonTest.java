package datastructures.runtimeanalysis;

import java.util.Arrays;
import java.util.Random;

public class SortComparisonTest {
    // bubble sort
    static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    // merge sort
    static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];
        for (int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) arr[k++] = L[i++];
            else arr[k++] = R[j++];
        }

        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    // quick sort
    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // test
    static void runBenchmark(int size) {
        Random random = new Random();

        int[] base = new int[size];
        for (int i = 0; i < size; i++) {
            base[i] = random.nextInt(size);
        }

        int[] arr1 = Arrays.copyOf(base, base.length);
        int[] arr2 = Arrays.copyOf(base, base.length);
        int[] arr3 = Arrays.copyOf(base, base.length);

        // Bubble Sort
        long startBubble = System.nanoTime();
        bubbleSort(arr1);
        long endBubble = System.nanoTime();

        // Merge Sort
        long startMerge = System.nanoTime();
        mergeSort(arr2, 0, arr2.length - 1);
        long endMerge = System.nanoTime();

        // Quick Sort
        long startQuick = System.nanoTime();
        quickSort(arr3, 0, arr3.length - 1);
        long endQuick = System.nanoTime();

        System.out.println("Dataset size: " + size);
        System.out.println("Bubble Sort Time : " + (endBubble - startBubble) + " ns");
        System.out.println("Merge Sort Time  : " + (endMerge - startMerge) + " ns");
        System.out.println("Quick Sort Time  : " + (endQuick - startQuick) + " ns");
        System.out.println("----------------------------------------");
    }

    public static void main(String[] args) {

        int[] sizes = {100, 1_000, 5_000, 10_000, 50_000};

        for (int size : sizes) {
            runBenchmark(size);
        }
    }
}

