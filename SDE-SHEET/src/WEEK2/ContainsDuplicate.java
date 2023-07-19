package WEEK2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate {
    public static void main(String[] args) {
        System.out.println(contains(new int[]{1,2,3}));
    }

    // brute force

    public static boolean containsD(int[] nums) {
        int n = nums.length;
        int temp=0;
        Arrays.sort(nums);
        for(int i=0 ;i<n-1 ;i++){
            if(nums[i]==nums[i+1])
                temp++;
        }
        return temp>0;
    }

    // optimal

    public static boolean contains(int[] nums){
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<n; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], 1);
            }
            else{
                map.put(nums[i], map.get(nums[i])+1);
            }

            if(map.get(nums[i])>1){
                return true;
            }
        }

        return false;
    }
}
