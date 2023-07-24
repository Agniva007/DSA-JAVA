package OneDdp;

import java.util.Arrays;

public class FrogJumpWithK {
    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        int[] heights = {10,40,30,10};
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        System.out.println(rec(n-1, heights, k));
        System.out.println(memo(n-1, heights, dp, k));
        System.out.println(tabu(heights, dp, k));
    }


    //Recursion
    public static int rec(int ind, int heights[], int k){
        if(ind == 0) return 0;
        int mini = Integer.MAX_VALUE;
        for(int i=1; i<=k; i++){
            if(ind-i >= 0){
                int jump = rec(ind-i, heights, k) + Math.abs(heights[ind] - heights[ind-i]);

                mini = Math.min(mini, jump);
            }
        }


        return mini;
    }

    //Memoisation
    public static int memo(int ind, int[] height, int[] dp, int k){
        if(ind==0) return 0;
        if(dp[ind]!=-1) return dp[ind];

        int mmSteps = Integer.MAX_VALUE;

        for(int j=1;j<=k;j++){
            if(ind-j>=0){
                int jump = memo(ind-j, height, dp, k)+ Math.abs(height[ind]-height[ind-j]);
                mmSteps= Math.min(jump, mmSteps);
            }
        }
        return dp[ind]= mmSteps;

    }

    //Tabulation
    public static int tabu(int[] heights, int[] dp, int k){
        int n = heights.length;
        dp[0] = 0;
        for(int ind=1; ind<n; ind++){
            int mini = Integer.MAX_VALUE;
            for(int j=1; j<=k; j++){
                if(ind-j>=0){
                    int jump = dp[ind-j] + Math.abs(heights[ind]-heights[ind-j]);
                    mini = Math.min(mini, jump);
                }
            }

            dp[ind] = mini;
        }

        return dp[n-1];
    }
}
