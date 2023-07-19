package Subsequence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrintAllSubsequence {
    public static void main(String[] args) {
        System.out.println(allPossibleStrings("abcd"));
    }

    private static List<String> a = new ArrayList<>();

    private static List<String> allPossibleStrings(String s)
    {
        // Code here

        findsubsequences(s, "", 0, s.length());
        a.remove("");
        Collections.sort(a);
        return a;
    }

    private static void findsubsequences(String s, String ans, int ind, int n)
    {
        if (ind == n) {
            a.add(ans);
            return;
        }

        // We add adding 1st character in string
        findsubsequences(s, ans + s.charAt(ind), ind+1, n);

        // Not adding first character of the string
        // because the concept of subsequence either
        // character will present or not
        findsubsequences(s, ans, ind+1, n);
    }
}
