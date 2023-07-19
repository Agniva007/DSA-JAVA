package Subsequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public static void main(String[] args) {
        System.out.println(combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        sum(candidates, target, 0, ans, new ArrayList<>());
        return ans;
    }

    public static void sum(int[] arr, int target, int index, List<List<Integer>> ans, List<Integer> ds){
        if(target == 0){
            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int i=index; i<arr.length; i++){
            if(i>index && arr[i]==arr[i-1]) continue;
            if(arr[i] > target) break;

            ds.add(arr[i]);
            sum(arr, target-arr[i], i+1, ans, ds);
            ds.remove(ds.size()-1);
        }
    }
}
