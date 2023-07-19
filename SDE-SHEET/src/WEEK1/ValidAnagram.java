package WEEK1;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
    }

    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        Map<Character, Integer> map = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                map.put(c, map.get(c)+1);
            }else{
                map.put(c, 1);
            }
        }

        for(int i=0; i<t.length(); i++){
            char c = t.charAt(i);
            if(!map.containsKey(c)){
                return false;
            }else{
                if(map.get(c)>0){
                    map.put(c, map.get(c)-1);
                }else{
                    return false;
                }
            }
        }

        return true;
    }
}
