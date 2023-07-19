package Easy;

public class LargestOddNumberInString {
    public static void main(String[] args) {
        System.out.println(largestOddNumber("345278"));
    }

    public static String largestOddNumber(String num) {
        for(int temp=num.length()-1; temp>=0; temp--){
            char c=num.charAt(temp);
            if(c%2!=0)
                return num.substring(0,temp+1);
        }
        return "";
    }
}
