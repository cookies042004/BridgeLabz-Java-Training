package datastructures.linearbinarysearch;

public class RotationPoint {
    static int findMinIndex(int[] arr){
        int low = 0;
        int high = arr.length - 1;

        if(arr[low] <= arr[high]){
            return low;
        }

        while(low <= high){
            int mid = low + (high - low) / 2;

            if (mid < high && arr[mid] > arr[mid + 1]) {
                return mid + 1;
            }

            if(mid > 0 && arr[mid] < arr[mid - 1]){
                return mid;
            }

            if(arr[mid] >= arr[low]){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};

        int index = findMinIndex(arr);

        System.out.println("Index of smallest element: " + index);
        System.out.println("Smallest element: " + arr[index]);
    }
}
