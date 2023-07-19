package BinarySearchOn;

// https://leetcode.com/problems/kth-missing-positive-number/
// TC --> O(logn) SC --> O(1)

public class KthMissingPositiveNumber {
    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{2,3,4,7,11}, 5));
    }

    public static int missingNumber(int[] arr, int k){
        int n = arr.length;
        int low = 0;
        int high = n-1;

        while(low <= high){
            int mid = low + (high-low)/2;
            int missing = arr[mid] - (mid+1);
            if(missing < k){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }

        return k+high+1; // or we can write k + (high+1) = k+low;
    }
}
