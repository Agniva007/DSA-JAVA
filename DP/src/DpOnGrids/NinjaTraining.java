package DpOnGrids;

import java.util.Arrays;

public class NinjaTraining {
    public static void main(String[] args) {
        int[][] points = {{10,40,70},{20,50,80},{30,60,90}};
        int n = points.length;
        int last = 3;
        int[][] dp = new int[n][last+1];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        System.out.println(rec(n-1, last, points));
        System.out.println(memo(n-1, last, points, dp));
        System.out.println(tab(n, points));
    }

    public static int rec(int day, int last, int[][] points){
        if(day==0){
            int maxi = Integer.MIN_VALUE;
            for(int i=0; i<=2; i++){
                if(i!=last){
                    maxi = Math.max(maxi, points[0][i]);
                }
            }

            return maxi;
        }

        int maxi = Integer.MIN_VALUE;
        for(int i=0; i<=2; i++){
            if(i!=last){
                int activity = points[day][i] + rec(day-1, i, points);
                maxi = Math.max(maxi, activity);
            }
        }

        return maxi;
    }

    // Memoization
    static int memo(int day, int last, int[][] points, int[][] dp){
        if(dp[day][last]!=-1) return dp[day][last];
        if(day==0){
            int maxi = 0;
            for(int i=0; i<=2; i++){
                if(i!=last){
                    maxi = Math.max(maxi, points[0][i]);
                }
            }
            return dp[day][last] = maxi;
        }
        int maxi = 0;
        for(int i=0; i<=2; i++){
            if(i != last){
                int activity = points[day][i] + memo(day-1, i, points, dp);
                maxi = Math.max(maxi, activity);
            }
        }
        return maxi;
    }
    //Tabulation
    static int tab(int n, int[][] points){
        int[][] dp = new int[n][4];
        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][0], points[0][1]);
        dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        for (int day = 1; day < n; day++) {
            for (int last = 0; last < 4; last++) {
                dp[day][last] = 0;
                for (int task = 0; task <= 2; task++) {
                    if (task != last) {
                        int activity = points[day][task] + dp[day - 1][task];
                        dp[day][last] = Math.max(dp[day][last], activity);
                    }
                }
            }

        }

        return dp[n - 1][3];
    }
}
