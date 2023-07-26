package DpOnSubsequence;

import java.util.Arrays;

public class CountSubsetWithSumK {
    public static void main(String[] args) {
        int[] arr = {1,2,2,3};
        int k=3;
        int n = arr.length;
        int[][] dp = new int[n][k+1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        System.out.println(rec(n-1, k, arr));
        System.out.println(memo(n-1, k, arr, dp));
        System.out.println(tabu(arr, k));
    }

    public static int rec(int ind, int target, int[] arr){
        if(target==0)
            return 1;

        if(ind == 0)
            return arr[0] == target?1:0;

        int notTaken = rec(ind-1, target, arr);

        int taken = 0;
        if(arr[ind]<=target)
            taken = rec(ind-1, target-arr[ind], arr);

        return notTaken + taken;
    }

    public static int memo(int ind, int target, int[] arr,int[][] dp){
        if(target==0)
            return 1;

        if(ind == 0)
            return arr[0] == target?1:0;

        if(dp[ind][target]!=-1)
            return dp[ind][target];

        int notTaken = memo(ind-1,target,arr,dp);

        int taken = 0;
        if(arr[ind]<=target)
            taken = memo(ind-1,target-arr[ind],arr,dp);

        return dp[ind][target]= notTaken + taken;
    }

    public static int tabu(int[] num, int k){
        int n = num.length;

        int[][] dp=new int[n][k+1];

        for(int i=0; i<n; i++){
            dp[i][0] = 1;
        }

        if(num[0]<=k)
            dp[0][num[0]] = 1;

        for(int ind = 1; ind<n; ind++){
            for(int target= 1; target<=k; target++){

                int notTaken = dp[ind-1][target];

                int taken = 0;
                if(num[ind]<=target)
                    taken = dp[ind-1][target-num[ind]];

                dp[ind][target]= notTaken + taken;
            }
        }

        return dp[n-1][k];


    }
}
