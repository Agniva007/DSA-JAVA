package OneDdp;

import java.util.Arrays;

public class FrogJump {
    public static void main(String[] args) {
        int n = 4;
        int[] heights = {10,20,30,10};
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        System.out.println(rec(n-1, heights));
        System.out.println(memo(n-1, heights, dp));
        System.out.println(tabu(heights, dp));
    }

    //Recursion
    public static int rec(int ind, int heights[]){
        if(ind == 0) return 0;

        int left = rec(ind-1, heights) + Math.abs(heights[ind] - heights[ind-1]);
        int right = Integer.MAX_VALUE;
        if(ind>1) right = rec(ind-2, heights) + Math.abs(heights[ind] - heights[ind-2]);

        return Math.min(left, right);
    }

    //Memoisation
    public static int memo(int ind, int heights[], int[] dp){
        if(ind == 0) return 0;
        if(dp[ind]!=-1) return dp[ind];

        int left = memo(ind-1, heights, dp) + Math.abs(heights[ind] - heights[ind-1]);
        int right = Integer.MAX_VALUE;
        if(ind>1) right = memo(ind-2, heights, dp) + Math.abs(heights[ind] - heights[ind-2]);

        return dp[ind] = Math.min(left, right);
    }

    //Tabulation
    public static int tabu(int[] heights, int[] dp){
        int n = heights.length;
        dp[0] = 0;
        for(int ind=1; ind<n; ind++){
            int jumpOne = dp[ind-1] + Math.abs(heights[ind]-heights[ind-1]);
            int jumpTwo = Integer.MAX_VALUE;
            if(ind>1) jumpTwo = dp[ind-2] + Math.abs(heights[ind]-heights[ind-2]);

            dp[ind] = Math.min(jumpOne, jumpTwo);
        }

        return dp[n-1];
    }
}
