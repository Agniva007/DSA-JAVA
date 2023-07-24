package OneDdp;

import java.util.Arrays;

public class ClimbingStairs {
    public static void main(String[] args) {
        System.out.println(cs(3));
        System.out.println(op(3));
    }

    // Recursion

    public static int cs(int n){
        if(n==0) return 1;
        if(n==1) return 1;

        return cs(n-1)+cs(n-2);
    }

    // Optimise

    public static int op(int n){
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);

        dp[0] = 1;
        dp[1] = 1;

        for(int i=2; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }
}
