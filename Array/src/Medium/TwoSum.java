package Medium;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] arr = sum(new int[]{2,7,11,15}, 9);
        System.out.println(arr[0] + " " + arr[1]);
    }

    public static int[] sum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(target - nums[i])){
                return new int[]{map.get(target - nums[i]), i};
            }else{
                map.put(nums[i], i);
            }
        }

        return new int[]{-1, -1};
    }
}
