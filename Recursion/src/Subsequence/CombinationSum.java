package Subsequence;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        System.out.println(combination(new int[]{2,3,6,7}, 7));
    }

    public static List<List<Integer>> combination(int[] candidates, int target){
        List<List<Integer>> ans = new ArrayList<>();
        sum(candidates, target, 0, ans, new ArrayList<>());
        return ans;
    }

    public static void sum(int[] arr, int target, int index, List<List<Integer>> ans, List<Integer> ds){
        if(index == arr.length){
            if(target == 0){
                ans.add(new ArrayList<>(ds));
            }
            return;
        }

        //take
        if(arr[index] <= target){
            ds.add(arr[index]);
            sum(arr, target-arr[index], index, ans, ds);
            ds.remove(ds.size()-1);
        }
        //not take
        sum(arr, target, index+1, ans, ds);

    }
}
