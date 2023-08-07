package DpOnString;

import java.util.Arrays;

public class LongestCommonSubstring {
    public static void main(String[] args) {
        String s1= "abcjklp";
        String s2= "acjkp";

        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n+1][m+1];
        for(int[] row : dp) Arrays.fill(row, -1);

        System.out.println(lcs(s1, s2, n-1, m-1, 0));
        System.out.println(tabu(s1, s2, dp));
    }

    static int lcs(String X, String Y, int i, int j, int count)
    {

        if (i == 0 || j == 0) {
            return count;
        }

        if (X.charAt(i - 1) == Y.charAt(j - 1)){
            count = lcs(X, Y, i - 1, j - 1, count + 1);
        }
        count = Math.max(count, Math.max(lcs(X, Y, i, j - 1, 0), lcs(X, Y, i - 1, j, 0)));
        return count;
    }

    private static int tabu(String s1, String s2, int[][] dp) {

        int n=s1.length();
        int m=s2.length();

        for(int i=0;i<=n;i++){
            dp[i][0] = 0;
        }
        for(int i=0;i<=m;i++){
            dp[0][i] = 0;
        }
        int ans = 0;
        for(int ind1=1;ind1<=n;ind1++){
            for(int ind2=1;ind2<=m;ind2++){
                if(s1.charAt(ind1-1)==s2.charAt(ind2-1)){
                    dp[ind1][ind2] = 1 + dp[ind1-1][ind2-1];
                    ans = Math.max(ans, dp[ind1][ind2]);
                }
                else
                    dp[ind1][ind2] = 0;
            }
        }

        return ans;
    }
}
