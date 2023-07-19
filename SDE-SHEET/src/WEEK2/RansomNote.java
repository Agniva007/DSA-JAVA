package WEEK2;

import java.util.HashMap;

public class RansomNote {
    public static void main(String[] args) {
        System.out.println(ransom("aab", "baa"));
    }

    public static boolean ransom(String ransomNote, String magazine){
        HashMap<Character, Integer> map1 = new HashMap<>();

        for(int i=0; i<magazine.length(); i++){
            char ch = magazine.charAt(i);
            map1.put(ch, map1.getOrDefault(ch, 0)+1);
        }

        for(int i=0; i<ransomNote.length(); i++){
            char ch = ransomNote.charAt(i);
            if(map1.containsKey(ch) == false)
                return false;
            else{
                map1.put(ch, map1.get(ch)-1);
                if(map1.get(ch)==0){
                    map1.remove(ch);
                }
            }
        }

        return true;
    }
}
