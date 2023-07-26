package DpOnGrids;

public class MinimumPathSumInTriangularGrid {
    public static void main(String[] args) {
        int[][] triangle = {{2},{3,4},{6,5,7},{4,1,8,3}};

    }

    public static int rec(int i, int j, int n, int[][] triangle){
        if(i == n-1) return triangle[i][j];

        int down = triangle[i][j] + rec(i+1, j, n, triangle);
        int diagonal = triangle[i][j] + rec(i+1, j+1, n, triangle);

        return Math.min(down, diagonal);
    }

    public static int memo(int i, int j, int n, int[][] triangle, int[][] dp){
        if(i == n-1) return triangle[i][j];
        if(dp[i][j] != -1) return dp[i][j];
        int down = triangle[i][j] + memo(i+1, j, n, triangle, dp);
        int diagonal = triangle[i][j] + memo(i+1, j+1, n, triangle, dp);

        return dp[i][j] = Math.min(down, diagonal);
    }

    public static int tabu(int m, int n, int[][] triangle, int[][] dp){
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i==0 && j==0)
                    dp[i][j] = triangle[i][j];
                else{
                    int up = triangle[i][j];
                    if(i>0)
                        up += dp[i-1][j];
                    else
                        up += 1000000;
                    int diagonal = triangle[i][j];
                    if(j>0)
                        diagonal += dp[i-1][j-1];
                    else
                        diagonal += 1000000;

                    dp[i][j] = Math.min(up, diagonal);
                }
            }
        }

        return dp[m-1][n-1];
    }
}
