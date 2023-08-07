package DpOnLIS;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] arr = {10,9,2,5,3,7,101,18};

        int n = arr.length;
        int[][] dp = new int[n][n+1];
        for(int[] row : dp) Arrays.fill(row, -1);
        System.out.println(lis(0, n, -1, arr));
        System.out.println(memo(0, n, -1, arr, dp));
    }

    public static int lis(int ind, int n, int prev_ind, int[] arr){
        if(ind == n) return 0;

        int notTake = 0 + lis(ind+1, n, prev_ind, arr);

        int take = 0;
        if(prev_ind == -1 || arr[prev_ind] < arr[ind]){
            take = 1 + lis(ind+1, n, ind, arr);
        }

        return Math.max(take, notTake);
    }

    public static int memo(int ind, int n, int prev_ind, int[] arr, int[][] dp){
        if(ind == n) return 0;

        if(dp[ind][prev_ind+1] != -1) return dp[ind][prev_ind+1];

        int notTake = 0 + memo(ind+1, n, prev_ind, arr, dp);

        int take = 0;
        if(prev_ind == -1 || arr[prev_ind] < arr[ind]){
            take = 1 + memo(ind+1, n, ind, arr, dp);
        }

        return dp[ind][prev_ind+1]=Math.max(take, notTake);
    }
}
