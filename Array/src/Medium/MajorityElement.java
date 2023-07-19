package Medium;

// https://leetcode.com/problems/majority-element/

import java.util.HashMap;

public class MajorityElement {
    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{2,2,1,1,1,2,2}));
    }

    public static int majorityElement(int[] nums) {
        int size = nums.length;
        int count = size/2;

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<size; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i])+1);
            }else{
                map.put(nums[i], 1);
            }
        }

        for(int i=0; i<size; i++){
            if(map.get(nums[i]) > count){
                return nums[i];
            }
        }

        return -1;
    }
}
