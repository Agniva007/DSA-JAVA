package Medium;

import java.util.Stack;

public class MaximumNestingDepthOfParentheses {
    public static void main(String[] args) {
        System.out.println(maxDepth("(1+(2*3)+((8)/4))+1"));
    }

    public static int maxDepth(String s) {
        char arr[] = s.toCharArray();
        Stack<Character> st=new Stack<Character>();
        int max = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]=='(')
                st.push('(');
            else
            {
                if(arr[i]==')')
                    st.pop();
            }
            max=Math.max(max,st.size());
        }
        return max;
    }
}
