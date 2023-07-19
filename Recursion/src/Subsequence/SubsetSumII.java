package Subsequence;

// https://leetcode.com/problems/subsets-ii

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetSumII {
    public static void main(String[] args) {
        System.out.println(subsetsWithDup(new int[]{1,2,2}));
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        subset(nums, 0, ans, new ArrayList<>());
        return ans;
    }

    public static void subset(int[] nums, int ind, List<List<Integer>> ans, List<Integer> ds){
        ans.add(new ArrayList<>(ds));

        for(int i=ind; i<nums.length; i++){
            if(i>ind && nums[i]==nums[i-1]) continue;
            ds.add(nums[i]);
            subset(nums, i+1, ans, ds);
            ds.remove(ds.size()-1);
        }
    }
}
