package DpOnSubsequence;

import java.util.Arrays;

public class MinimumCoinChange {
    public static void main(String[] args) {
        int[] arr ={1,2,3};
        int target=7;
        int n = arr.length;
        int[][] dp = new int[n][target+1];
        for(int[] row : dp) Arrays.fill(row, -1);
        System.out.println(rec(n-1, target, arr));
        System.out.println(memo(n-1, target, arr, dp));
        System.out.println(tabu(arr, target));
    }

    public static int rec(int ind, int target, int[] arr){
        if(ind==0){
            if(target%arr[ind]==0) return target/arr[ind];
            else return 10000000;
        }

        int notTake = 0 + rec(ind-1, target, arr);
        int take = 10000000;
        if(arr[ind]<=target) take = 1 + rec(ind, target-arr[ind], arr);

        return Math.min(take, notTake);
    }

    public static int memo(int ind, int T, int[] arr, int[][] dp){

        if(ind == 0){
            if(T%arr[0] == 0) return T/arr[0];
            else return (int)Math.pow(10,9);
        }

        if(dp[ind][T]!=-1)
            return dp[ind][T];

        int notTaken = 0 + memo(ind-1, T, arr, dp);

        int taken = (int)Math.pow(10,9);
        if(arr[ind] <= T)
            taken = 1 + memo(ind, T-arr[ind], arr, dp);

        return dp[ind][T] = Math.min(notTaken,taken);
    }

    public static int tabu(int[] arr, int T){

        int n= arr.length;

        int dp[][]=new int[n][T+1];

        for(int i=0; i<=T; i++){
            if(i%arr[0] == 0)
                dp[0][i] = i/arr[0];
            else dp[0][i] = (int)Math.pow(10,9);
        }

        for(int ind = 1; ind<n; ind++){
            for(int target = 0; target<=T; target++){

                int notTake = 0 + dp[ind-1][target];
                int take = (int)Math.pow(10,9);
                if(arr[ind]<=target)
                    take = 1 + dp[ind][target - arr[ind]];

                dp[ind][target] = Math.min(notTake, take);
            }
        }

        int ans = dp[n-1][T];
        if(ans >=(int)Math.pow(10,9)) return -1;
        return ans;
    }

}
