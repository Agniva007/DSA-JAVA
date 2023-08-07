package DpOnString;

import java.util.Arrays;

public class EditDistance {
    public static void main(String[] args) {
        String s1 = "horse";
        String s2 = "ros";
        int n = s1.length();
        int m = s2.length();
        int[][] dp=new int[n][m];
        for(int row[]: dp)
            Arrays.fill(row,-1);
        System.out.println(memo(s1, s2, n-1, m-1, dp));
        System.out.println(tabu(s1, s2));
    }

//    return 1+f(i-1,j) // Insertion of character.
//    return 1+f(i,j-1) // Deletion of character.
//    return 1+f(i-1,j-1) // Replacement of character.

    // Base Case
    // We are reducing i and j in our recursive relation, there can be two possibilities,
    // either i becomes -1 or j becomes -1., i,e we exhaust either S1 or S2 respectively.
    // if i becomes -1 then we have to insert j+1 elements
    // if j becomes -1 then we have to delete i+1 elements

    private static int memo(String S1, String S2, int i, int j, int[][] dp){

        if(i<0)
            return j+1;
        if(j<0)
            return i+1;

        if(dp[i][j]!=-1) return dp[i][j];

        if(S1.charAt(i)==S2.charAt(j))
            return dp[i][j] =  0+memo(S1,S2,i-1,j-1,dp);

            // Minimum of three choices
        else return dp[i][j] = 1+Math.min(memo(S1,S2,i-1,j-1,dp),
                                 Math.min(memo(S1,S2,i-1,j,dp),memo(S1,S2,i,j-1,dp)));

    }

    private static int tabu(String S1, String S2){

        int n = S1.length();
        int m = S2.length();

        int[][] dp=new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            dp[i][0] = i;
        }
        for(int j=0;j<=m;j++){
            dp[0][j] = j;
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(S1.charAt(i-1)==S2.charAt(j-1))
                    dp[i][j] = 0+dp[i-1][j-1];

                else dp[i][j] = 1+Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));
            }
        }

        return dp[n][m];
    }
}
