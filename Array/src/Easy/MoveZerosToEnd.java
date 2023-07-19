package Easy;

public class MoveZerosToEnd {
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,5,0,2,6};
        moveZeroes(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static void moveZeroes(int[] nums) {
        int n = nums.length;
        int count = 0;
        for(int i=0; i<n; i++){
            if(nums[i] != 0){
                nums[count] = nums[i];
                count++;
            }
        }

        for(int i=count; i<n; i++){
            nums[i] = 0;
        }
    }
}
