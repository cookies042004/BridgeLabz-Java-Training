package datastructures.linearbinarysearch;

public class FirstAndLastOccurrence {
    // this function return the first occurrence of the target value
    static int firstOccurrence(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        int firstIndex = -1;

        while(left <= right){
            int mid = left + (right - left) / 2;

            if(nums[mid] == target){
                firstIndex = mid;
                right = mid - 1; // continue searching first in left half
            }
            else if(nums[mid] < target){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }

        return firstIndex;
    }

    // this function return last occurrence of the target value
    static int lastOccurrence(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        int lastIndex = -1;

        while(left <= right){
            int mid = left + (right - left) / 2;

            if(nums[mid] == target){
                lastIndex = mid;
                left = mid + 1; // continue searching for last in right half
            }
            else if(nums[mid] < target){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }

        return lastIndex;
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 8, 10};
        int target = 8;

        int first = firstOccurrence(nums, target);
        int last = lastOccurrence(nums, target);

        System.out.println("First occurrence of : " + target + " is at index :" + first);
        System.out.println("Last occurrence is : " + target + " is at index :"  + last);
    }
}
