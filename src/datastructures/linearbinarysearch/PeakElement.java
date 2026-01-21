package datastructures.linearbinarysearch;

public class PeakElement {
    static int getPeakElement(int[] arr) {
        int low = 0;
        int high = arr.length - 1;

        // Handle single element
        if (arr.length == 1) {
            return 0;
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Check if mid is a peak
            if (
                    (mid == 0 || arr[mid] > arr[mid - 1]) &&
                            (mid == arr.length - 1 || arr[mid] > arr[mid + 1])
            ) {
                return mid;
            }

            // If right neighbor is bigger, move right
            if (mid < arr.length - 1 && arr[mid] < arr[mid + 1]) {
                low = mid + 1;
            }
            // Else move left
            else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 6, 5, 3};

        int index = getPeakElement(arr);

        if (index == -1) {
            System.out.println("No peak element is there");
        } else {
            System.out.println("Peak element is: " + arr[index]);
            System.out.println("Peak index is: " + index);
        }
    }
}
