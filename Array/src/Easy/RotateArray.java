package Easy;

//https://leetcode.com/problems/rotate-array/

public class RotateArray {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8};
        rotate(nums, 4);
        for (int i=0; i< nums.length; i++){
            System.out.println(nums[i]);
        }
    }

    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k%n;

        reverse(0, n-k-1, nums);
        reverse(n-k, n-1, nums);
        reverse(0, n-1, nums);
    }

    public static void reverse(int start, int end, int[] nums){
        while(start <= end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
