package Easy;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicString {
    public static void main(String[] args) {
        System.out.println(isIsomorphic("abb", "cdd"));
    }

    public static boolean isIsomorphic(String s, String t) {
        return transformString(s).equals(transformString(t));
    }

    private static String transformString(String s) {
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);

            if (!map.containsKey(ch)) {
                map.put(ch, i);
            }

            sb.append(Integer.toString(map.get(ch)));
            sb.append(" ");
        }
        return sb.toString();
    }
}
