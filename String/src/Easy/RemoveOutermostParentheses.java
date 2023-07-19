package Easy;

public class RemoveOutermostParentheses {
    public static void main(String[] args) {
        System.out.println(remove("(()())(())"));
    }

    public static String remove(String str){
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for(int i=0; i<str.length(); i++){
            int ch = str.charAt(i);
            if(ch == '('){
                count++;
                if(count>1) sb.append('(');
            }
            else if(ch == ')'){
                if(count > 1) sb.append(')');
                count--;
            }
        }

        return sb.toString();
    }
}
