package DpOnSubsequence;

import java.util.Arrays;

public class SubsetSumEqualTarget {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        int k = 4;
        int n = arr.length;
        int[][] dp = new int[n][k+1];
        for(int[] row : dp) Arrays.fill(row, -1);

        System.out.println(rec(n-1, k, arr));
        System.out.println(memo(n-1, k, arr, dp));
        System.out.println(tabu(n, k, arr));
    }

    public static boolean rec(int ind, int target, int[] arr){
        if(target == 0) return true;
        if(ind == 0) return arr[ind]==target;

        boolean notTaken = rec(ind-1, target, arr);
        boolean taken = false;
        if(arr[ind] <= target){
            taken = rec(ind-1, target-arr[ind], arr);
        }

        return taken || notTaken;
    }

    public static boolean memo(int ind, int target,int[] arr,int[][] dp){
        if(target==0)
            return true;

        if(ind == 0)
            return arr[0] == target;

        if(dp[ind][target]!=-1)
            return dp[ind][target]==0?false:true;

        boolean notTaken = memo(ind-1,target,arr,dp);

        boolean taken = false;
        if(arr[ind]<=target)
            taken = memo(ind-1,target-arr[ind],arr,dp);
        dp[ind][target]=notTaken||taken?1:0;
        return notTaken||taken;
    }

    public static boolean tabu(int n, int k,int[] arr){


        boolean dp[][]= new boolean[n][k+1];

        for(int i=0; i<n; i++){
            dp[i][0] = true;
        }

        if(arr[0]<=k)
            dp[0][arr[0]] = true;

        for(int ind = 1; ind<n; ind++){
            for(int target= 1; target<=k; target++){

                boolean notTaken = dp[ind-1][target];

                boolean taken = false;
                if(arr[ind]<=target)
                    taken = dp[ind-1][target-arr[ind]];

                dp[ind][target]= notTaken||taken;
            }
        }

        return dp[n-1][k];
    }
}
