package Easy;

public class SingleNumber {
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{2,2,1}));
    }

    public static int singleNumber(int[] nums) {
        int res=0;
        for(int i=0; i<nums.length; i++){
            res = res ^ nums[i];
        }
        return res;
    }
}
