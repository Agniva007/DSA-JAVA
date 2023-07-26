package DpOnGrids;

import java.util.Arrays;

public class UniquePathsII {
    public static void main(String[] args) {
        int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] dp = new int[n][m+1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        System.out.println(rec(n-1, m-1, obstacleGrid));
        System.out.println(memo(n-1, m-1, obstacleGrid, dp));
        System.out.println(tabu(n, m, obstacleGrid, dp));
    }

    public static int rec(int i, int j, int[][] obstacleGrid){
        if(i>=0 && j>=0 && obstacleGrid[i][j]==1) return 0;
        if(i==0 && j==0) return 1;
        if(i<0 || j<0) return 0;

        int up = rec(i-1, j, obstacleGrid);
        int left = rec(i, j-1, obstacleGrid);

        return up+left;
    }

    public static int memo(int i, int j, int[][] obstacleGrid, int[][] dp){
        if(i>=0 && j>=0 && obstacleGrid[i][j]==1) return 0;
        if(i==0 && j==0) return 1;
        if(i<0 || j<0) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int up = memo(i-1, j, obstacleGrid, dp);
        int left = memo(i, j-1, obstacleGrid, dp);

        return dp[i][j] = up+left;
    }

    public static int tabu(int m, int n, int[][] obstacleGrid, int[][] dp) {

        for(int i=0; i<m ;i++){
            for(int j=0; j<n; j++){

                //base condition
                if(i>=0 && j>=0 && obstacleGrid[i][j]==1) {
                    dp[i][j] = 0;
                    continue;
                }

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
