package Medium;

public class RomanToInteger {
    public static void main(String[] args) {
        System.out.println(romanToInt("LVIII"));
    }

    public static int romanToInt(String s) {
        int result = 0;
        for(int i=0; i<s.length(); i++) {
            int current = convertInteger(s.charAt(i));

            if (s.length()==1)
                result = current;
            else {
                if (i<s.length()-1) {
                    int next = convertInteger(s.charAt(i+1));
                    if (current < next) {
                        result += next-current;
                        i += 1;
                    } else
                        result += current;
                }
                else {
                    result += current;
                }
            }
        }

        return result;
    }

    public static int convertInteger(char c){
        if(c=='I')
            return 1;
        else if(c=='V')
            return 5;
        else if(c=='X')
            return 10;
        else if(c=='L')
            return 50;
        else if(c=='C')
            return 100;
        else if(c=='D')
            return 500;
        else if(c=='M')
            return 1000;
        else
            return 0;
    }
}
