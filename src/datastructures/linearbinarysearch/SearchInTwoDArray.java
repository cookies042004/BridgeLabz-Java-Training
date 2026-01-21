package datastructures.linearbinarysearch;

public class SearchInTwoDArray{
    static boolean searchMatrix(int[][] arr, int target){
        int rows = arr.length;
        int cols = arr[0].length;

        int left = 0;
        int right = rows * cols - 1;

        while(left <= right){
            int mid = left + (right - left) / 2;

            int row = mid / cols;
            int col = mid % cols;

            int midValue = arr[row][col];

            if(midValue == target){
                return true;
            }

            if(midValue < target){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };

        int target = 16;

        boolean found = searchMatrix(matrix, target);

        System.out.println("Target found: " + found);
    }
}
