package Easy;

//https://leetcode.com/problems/remove-duplicates-from-sorted-array/

public class RemoveDuplicates {
    public static void main(String[] args) {
        System.out.println(remove(new int[]{0,0,1,1,1,1,2,2,3,3,3,4,4,4,4,4,4}));
    }

    public static int remove(int[] nums) {
        int count = 0;

        for (int i = 1; i < nums.length; i++)
        {
            if (nums[i] == nums[i - 1]){
                count++;
            }
            nums[i - count] = nums[i];
        }

        return nums.length - count;
    }
}
