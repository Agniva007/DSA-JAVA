package OneDdp;

import java.util.Arrays;

public class HouseRobber {
    public static void main(String[] args) {
        int n = 4;
        int[] nums = {1,2,3,1};
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        System.out.println(rec(n-1, nums));
        System.out.println(memo(n-1, nums, dp));
    }

    // Recursion
    public static int rec(int ind, int[] nums){
        if(ind < 0) return 0;

        int pick = nums[ind] + rec(ind-2, nums);
        int notPick = 0 + rec(ind-1, nums);

        return Math.max(pick, notPick);
    }

    // Memoisation
    public static int memo(int ind, int[] nums, int[] dp){
        if(ind < 0) return 0;

        if(dp[ind] != -1) return dp[ind];

        int pick = nums[ind] + memo(ind-2, nums, dp);
        int notPick = 0 + memo(ind-1, nums, dp);

        return dp[ind] = Math.max(pick, notPick);
    }
}
