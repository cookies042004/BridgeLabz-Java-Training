package datastructures.linearbinarysearch;

public class FirstNegativeLinearSearch {
    // Method to find index of first negative number
    static int findFirstNegative(int[] arr) {

        // Step 1: Iterate through the array
        for (int i = 0; i < arr.length; i++) {

            // Step 2: Check if current element is negative
            if (arr[i] < 0) {
                // Step 3: Return index if found
                return i;
            }
        }

        // Step 4: Return -1 if no negative number found
        return -1;
    }

    public static void main(String[] args) {
        int[] numbers = {4, 7, 3, -2, 5, -8};

        int index = findFirstNegative(numbers);

        if (index != -1) {
            System.out.println("First negative number found at index: " + index);
        } else {
            System.out.println("No negative number found in the array");
        }
    }
}

