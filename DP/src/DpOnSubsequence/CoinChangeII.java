package DpOnSubsequence;

import java.util.Arrays;

public class CoinChangeII {
    public static void main(String[] args) {
        int[] arr ={1,2,5};
        int target=5;
        int n = arr.length;
        int[][] dp = new int[n][target+1];
        for(int[] row : dp) Arrays.fill(row, -1);
        System.out.println(rec(n-1, target, arr));
        System.out.println(memo(n-1, target, arr, dp));
//        System.out.println(tabu(arr, target));
    }

    public static int rec(int ind, int target, int[] arr){
        if(ind==0){
            if(target%arr[ind]==0) return 1;
            else return 0;
        }

        int notTake = rec(ind-1, target, arr);
        int take = 0;
        if(arr[ind]<=target) take = rec(ind, target-arr[ind], arr);

        return take+notTake;
    }

    public static int memo(int ind, int T, int[] arr, int[][] dp){

        if(ind == 0){
            if(T%arr[0] == 0) return 1;
            else return 0;
        }

        if(dp[ind][T]!=-1)
            return dp[ind][T];

        int notTake = memo(ind-1, T, arr, dp);

        int take = 0;
        if(arr[ind] <= T)
            take = memo(ind, T-arr[ind], arr, dp);

        return dp[ind][T] = notTake+take;
    }
}
