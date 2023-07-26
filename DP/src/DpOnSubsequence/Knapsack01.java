package DpOnSubsequence;

public class Knapsack01 {
    public static void main(String[] args) {

    }

    static int rec(int[] wt,int[] val, int ind, int W){

        if(ind == 0){
            if(wt[0] <=W) return val[0];
            else return 0;
        }

        int notTaken = 0 + rec(wt,val,ind-1,W);

        int taken = Integer.MIN_VALUE;
        if(wt[ind] <= W)
            taken = val[ind] + rec(wt,val,ind-1,W-wt[ind]);

        return Math.max(notTaken,taken);
    }

    static int memo(int[] wt,int[] val, int ind, int W,int[][] dp){

        if(ind == 0){
            if(wt[0] <=W) return val[0];
            else return 0;
        }

        if(dp[ind][W]!=-1)
            return dp[ind][W];

        int notTaken = 0 + memo(wt,val,ind-1,W,dp);

        int taken = Integer.MIN_VALUE;
        if(wt[ind] <= W)
            taken = val[ind] + memo(wt,val,ind-1,W-wt[ind],dp);

        return dp[ind][W] = Math.max(notTaken,taken);
    }
}
