package datastructures.sortingalgo;

public class QuickSort {

    // This method places the pivot element at its correct position
    // and arranges smaller elements to the left and larger to the right
    static int partition(int[] arr, int low, int high) {

        // Choose last element as pivot
        int pivot = arr[high];
        int i = low - 1; // Index of smaller element

        // Traverse and rearrange elements based on pivot
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;

                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Place pivot at correct position
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1; // Return pivot index
    }

    // Recursive Quick Sort function
    static void quickSort(int[] arr, int low, int high) {

        // Base condition
        if (low < high) {

            // Partition the array
            int pi = partition(arr, low, high);

            // Recursively sort left subarray
            quickSort(arr, low, pi - 1);

            // Recursively sort right subarray
            quickSort(arr, pi + 1, high);
        }
    }

    public static void main(String[] args) {
        int[] prices = {999, 499, 799, 199};

        quickSort(prices, 0, prices.length - 1);

        for (int x : prices)
            System.out.print(x + " ");
    }
}

