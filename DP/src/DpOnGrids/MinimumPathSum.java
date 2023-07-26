package DpOnGrids;

import java.util.Arrays;

public class MinimumPathSum {
    public static void main(String[] args) {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n+1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        System.out.println(rec(m-1, n-1, grid));
        System.out.println(memo(m-1, n-1, grid, dp));
        System.out.println(tabu(m, n, grid, dp));
    }

    public static int rec(int i, int j, int[][] grid){
        if(i==0 && j==0) return grid[0][0];
        if(i<0 || j<0) return 1000000;

        int up = grid[i][j] + rec(i-1, j, grid);
        int left = grid[i][j] + rec(i, j-1, grid);

        return Math.min(up, left);
    }

    public static int memo(int i, int j, int[][] grid, int[][] dp){
         if(i==0 && j==0) return grid[0][0];
         if(i<0 || j<0) return 1000000;
         if(dp[i][j] != -1) return dp[i][j];
         int up = grid[i][j] + memo(i-1, j, grid, dp);
         int left = grid[i][j] + memo(i, j-1, grid, dp);

         return dp[i][j] = Math.min(up, left);
    }

    public static int tabu(int m, int n, int[][] grid, int[][] dp){
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i==0 && j==0)
                    dp[i][j] = grid[i][j];
                else{
                    int up = grid[i][j];
                    if(i>0)
                        up += dp[i-1][j];
                    else
                        up += 1000000;
                    int left = grid[i][j];
                    if(j>0)
                        left += dp[i][j-1];
                    else
                        left += 1000000;

                    dp[i][j] = Math.min(up, left);
                }
            }
        }

        return dp[m-1][n-1];
    }
}
