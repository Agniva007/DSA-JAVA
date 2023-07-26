package DpOnSubsequence;

import java.util.Arrays;

public class PartitionEqualSubsetSum {
    public static void main(String[] args) {
        int[] arr = {2,3,3,3,4,5};
        int n = arr.length;

        System.out.println(canPartition(n, arr));
    }

    public static boolean canPartition(int n, int[] arr){

        int totSum=0;

        for(int i=0; i<n;i++){
            totSum+= arr[i];
        }

        if (totSum%2==1) return false;

        else{
            int k = totSum/2;
            int dp[][]=new int[n][k+1];
            for(int row[]: dp)
                Arrays.fill(row,-1);
            return memo(n-1, k, arr, dp);
        }
    }

    public static boolean memo(int ind, int target, int arr[], int[][] dp){
        if(target==0)
            return true;

        if(ind == 0)
            return arr[0] == target;

        if(dp[ind][target]!=-1)
            return dp[ind][target]==0?false:true;

        boolean notTaken = memo(ind-1, target, arr, dp);

        boolean taken = false;
        if(arr[ind]<=target)
            taken = memo(ind-1, target-arr[ind], arr, dp);
        dp[ind][target]=notTaken||taken?1:0;
        return notTaken||taken;
    }

}
