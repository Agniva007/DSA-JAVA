package BinarySearchOn;

//https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/
// TC --> O(log(max(arr[]))*N), SC --> O(1)

public class SmallestDivisorWithThreshold {
    public static void main(String[] args) {
        System.out.println(smallestDivisor(new int[]{1,2,5,9}, 6));
    }

    public static int smallestDivisor(int[] nums, int threshold){
        int n = nums.length;
        if(n > threshold) return -1;
        int maxi = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            maxi = Math.max(maxi, nums[i]);
        }

        int low = 1;
        int high = maxi;

        while(low<=high){
            int mid = low + (high-low)/2;
            if(sumByD(nums, mid) <= threshold) {
                high = mid - 1;
            }else{
                low = mid+1;
            }
        }

        return low;
    }

    public static int sumByD(int[] nums, int div){
        int n = nums.length;
        int sum = 0;
        for(int i=0; i<n; i++){
            sum += Math.ceil((double) nums[i] / (double) div);
        }

        return sum;
    }
}
