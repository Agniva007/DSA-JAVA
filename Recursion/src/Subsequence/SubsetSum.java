package Subsequence;

import java.util.ArrayList;

public class SubsetSum {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(2);
        list.add(1);
        System.out.println(subsetSums(list, 3));
    }

    private static ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        subset(arr, 0, N, 0, ans);

        return ans;
    }

    private static void subset(ArrayList<Integer> arr, int ind, int n, int sum, ArrayList<Integer> ans){
        if(ind == n){
            ans.add(sum);
            return;
        }

        subset(arr, ind+1, n, sum+arr.get(ind), ans);

        subset(arr, ind+1, n, sum, ans);
    }
}
