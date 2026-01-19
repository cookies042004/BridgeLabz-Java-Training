package datastructures.sortingalgo;

public class CountingSort {
    // Counting Sort function (used when range is small)
    static void countingSort(int[] arr) {

        int minAge = 10;
        int maxAge = 18;
        int range = maxAge - minAge + 1;

        // Count array to store frequency of each age
        int[] count = new int[range];

        // Store count of each age
        for (int age : arr)
            count[age - minAge]++;

        // Modify original array using count array
        int index = 0;
        for (int i = 0; i < range; i++) {
            while (count[i] > 0) {
                arr[index++] = i + minAge;
                count[i]--;
            }
        }
    }

    public static void main(String[] args) {
        int[] ages = {12, 15, 10, 14, 12};

        countingSort(ages);

        for (int x : ages)
            System.out.print(x + " ");
    }
}
