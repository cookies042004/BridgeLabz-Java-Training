package datastructures.sortingalgo;

public class MergeSort {

    // This method merges two sorted subarrays into one sorted array
    // First subarray: arr[start ... mid]
    // Second subarray: arr[mid + 1 ... end]
    static void merge(int[] arr, int start, int mid, int end) {

        // Calculate sizes of two subarrays
        int n1 = mid - start + 1;
        int n2 = end - mid;

        // Create temporary arrays
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copy data to temporary arrays
        for (int i = 0; i < n1; i++)
            L[i] = arr[start + i];

        for (int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];

        // Initial indexes of left, right and merged subarray
        int i = 0, j = 0, k = start;

        // Merge the temporary arrays back into original array
        while (i < n1 && j < n2) {
            if (L[i] <= R[j])
                arr[k++] = L[i++];
            else
                arr[k++] = R[j++];
        }

        // Copy remaining elements of left array (if any)
        while (i < n1)
            arr[k++] = L[i++];

        // Copy remaining elements of right array (if any)
        while (j < n2)
            arr[k++] = R[j++];
    }

    // Recursive Merge Sort function
    static void mergeSort(int[] arr, int start, int end) {

        // Base condition: if array has more than one element
        if (start < end) {

            // Find the middle point
            int mid = (start + end) / 2;

            // Sort first half
            mergeSort(arr, start, mid);

            // Sort second half
            mergeSort(arr, mid + 1, end);

            // Merge the sorted halves
            merge(arr, start, mid, end);
        }
    }

    public static void main(String[] args) {

        int[] prices = {450, 299, 1200, 799};

        // call merge sort on the array
        mergeSort(prices, 0, prices.length - 1);

        // Print sorted array
        for (int x : prices)
            System.out.print(x + " ");
    }
}
