package WEEK1;

import java.util.Stack;

public class ValidParenthesis {
    public static void main(String[] args) {
        System.out.println(isValid("({[]})"));
    }

    public static boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(!st.isEmpty() && ((c==')' && st.peek()=='(')
                    || (c=='}' && st.peek()=='{')
                    || (c==']' && st.peek()=='['))){
                st.pop();
            } else{
                st.push(c);
            }
        }

        return st.isEmpty();
    }
}
