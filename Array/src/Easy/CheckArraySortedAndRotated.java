package Easy;

// https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/

public class CheckArraySortedAndRotated {
    public static void main(String[] args) {
        System.out.println(check(new int[]{3,4,5,1,2}));
    }

    public static boolean check(int[] nums) {
        int count = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] > nums[(i+1)%nums.length]){
                count++;
            }
        }

        return count<=1;
    }
}
