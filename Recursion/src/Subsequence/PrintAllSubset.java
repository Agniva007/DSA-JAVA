package Subsequence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrintAllSubset {
    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1,2,3}));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int n = nums.length;
        print(list, nums, 0, n, new ArrayList<>());
        return list;
    }

    public static void print(List<List<Integer>> list, int[] nums, int ind, int n, List<Integer> temp){
        if(ind == n){
            list.add(new ArrayList<>(temp));
            return;
        }

        temp.add(nums[ind]);
        print(list, nums, ind+1, n, temp);
        temp.remove(temp.size()-1);
        print(list, nums, ind+1, n, temp);
    }
}
