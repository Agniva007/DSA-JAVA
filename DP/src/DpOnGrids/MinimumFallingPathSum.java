package DpOnGrids;

import java.util.Arrays;

public class MinimumFallingPathSum {
    public static void main(String[] args) {
        int[][] matrix = {{2,1,3},{6,5,4},{7,8,9}};
        int n = matrix.length;
        int m = matrix[0].length;
        int min = Integer.MAX_VALUE;
        int[][] dp = new int[n][m];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        for(int j=0; j<m; j++){
//            int ans = rec(n-1, j, m-1, matrix);
//            int ans = memo(n-1, j, m-1, matrix, dp);
            int ans = tabu(n, m, matrix, dp);
            min = Math.min(min, ans);
        }
        System.out.println(min);
    }

    public static int rec(int i, int j, int m, int[][] matrix){
        if(j<0 || j>m) return (int)Math.pow(10, 9);
        if(i==0) return matrix[0][j];

        int up = matrix[i][j] + rec(i-1, j, m, matrix);
        int ld = matrix[i][j] + rec(i-1, j-1, m, matrix);
        int rd = matrix[i][j] + rec(i-1, j+1, m, matrix);

        return Math.min(up, Math.min(ld, rd));
    }

    public static int memo(int i, int j, int m, int[][] matrix, int[][] dp){
        if(j<0 || j>m) return (int)Math.pow(10, 9);
        if(i==0) return matrix[0][j];
        if(dp[i][j] != -1) return dp[i][j];
        int up = matrix[i][j] + memo(i-1, j, m, matrix, dp);
        int ld = matrix[i][j] + memo(i-1, j-1, m, matrix, dp);
        int rd = matrix[i][j] + memo(i-1, j+1, m, matrix, dp);

        return dp[i][j] = Math.min(up, Math.min(ld, rd));
    }

    public static int tabu(int m, int n, int[][] matrix, int[][] dp){
        for(int j=0; j<m; j++){
            dp[0][j] = matrix[0][j];
        }

        for(int i=1; i<n; i++){
            for(int j=0;j<m;j++){

                int up = matrix[i][j] + dp[i-1][j];

                int leftDiagonal= matrix[i][j];
                if(j-1>=0) leftDiagonal += dp[i-1][j-1];
                else leftDiagonal += 1000000;

                int rightDiagonal = matrix[i][j];
                if(j+1<m) rightDiagonal += dp[i-1][j+1];
                else rightDiagonal += 1000000;

                dp[i][j] = Math.min(up, Math.min(leftDiagonal,rightDiagonal));

            }
        }

        int mini = Integer.MAX_VALUE;

        for(int j=0; j<m;j++){
            mini = Math.min(mini, dp[n-1][j]);
        }

        return mini;
    }
}
