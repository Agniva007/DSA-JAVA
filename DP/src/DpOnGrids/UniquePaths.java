package DpOnGrids;

import java.util.Arrays;

public class UniquePaths {
    public static void main(String[] args) {
        int m=3, n=2;
        int[][] dp = new int[m][n+1];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }
        System.out.println(rec(m-1, n-1));
        System.out.println(memo(m-1, n-1, dp));
        System.out.println(tabu(m, n, dp));
    }

    public static int rec(int i, int j){
        if(i==0 && j==0) return 1;
        if(i<0 || j<0) return 0;
        int up = rec(i-1, j);
        int left = rec(i, j-1);

        return up+left;
    }

    public static int memo(int i, int j, int[][] dp){
        if(i==0 && j==0) return 1;
        if(i<0 || j<0) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int up = memo(i-1, j, dp);
        int left = memo(i, j-1, dp);

        return dp[i][j] = up+left;
    }

    public static int tabu(int m, int n, int[][] dp) {

        for(int i=0; i<m ;i++){
            for(int j=0; j<n; j++){

                //base condition
                if(i==0 && j==0){
                    dp[i][j]=1;
                    continue;
                }

                int up=0;
                int left = 0;

                if(i>0)
                    up = dp[i-1][j];
                if(j>0)
                    left = dp[i][j-1];

                dp[i][j] = up+left;
            }
        }

        return dp[m-1][n-1];

    }
}

