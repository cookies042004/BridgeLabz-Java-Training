package datastructures.sortingalgo;

public class SelectionSort {
    // Selection Sort function
    static void selectionSort(int[] arr) {
        int n = arr.length;

        // One by one move boundary of unsorted array
        for (int i = 0; i < n - 1; i++) {

            // Assume the first unsorted element is the minimum
            int minIndex = i;

            // Find the minimum element in unsorted part
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex])
                    minIndex = j;
            }

            // Swap the found minimum with the first unsorted element
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] scores = {85, 72, 90, 60};

        selectionSort(scores);

        for (int x : scores)
            System.out.print(x + " ");
    }
}

