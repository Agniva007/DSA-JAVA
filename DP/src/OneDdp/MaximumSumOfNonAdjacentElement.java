package OneDdp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumSumOfNonAdjacentElement {
    public static void main(String[] args) {
        int n = 4;
        int[] nums = {2,1,4,9};
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        System.out.println(rec(n-1, nums));
        System.out.println(memo(n-1, nums, dp));
        System.out.println(tabu(n-1, nums, dp));
    }

    //Recursion

    public static int rec(int ind, int[] nums) {
        if(ind < 0) return 0;
        if(ind == 0) return nums[ind];

        int pick = nums[ind] + rec(ind-2, nums);
        int notPick = 0 + rec(ind-1, nums);

        return Math.max(pick, notPick);
    }

    //Memoisation

    public static int memo(int ind, int[] nums, int[] dp) {
        if(ind < 0) return 0;
        if(ind == 0) return nums[ind];

        if(dp[ind]!=-1) return dp[ind];

        int pick = nums[ind] + memo(ind-2, nums, dp);
        int notPick = 0 + memo(ind-1, nums, dp);

        dp[ind] = Math.max(pick, notPick);

        return dp[ind] = Math.max(pick, notPick);
    }

    //Tabulation

    public static int tabu(int ind, int[] nums, int[] dp){
        dp[0] = nums[0];

        for(int i=1; i<nums.length; i++){
            int pick = nums[i];
            if(i>1) pick += dp[i-2];

            int notPick = 0 + dp[i-1];

            dp[i] = Math.max(pick, notPick);
        }

        return dp[nums.length-1];
    }
}
