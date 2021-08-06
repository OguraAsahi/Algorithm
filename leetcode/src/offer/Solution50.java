package offer;

import java.util.HashMap;
import java.util.Map;

public class Solution50 {
    public char findUniqueChar(String s){
        if ("".equals(s)){
            return ' ';
        }
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            map.put(c, map.get(c) == null ? 1 : map.get(c) + 1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()){
            if (entry.getValue() == 1){
                return entry.getKey();
            }
        }
        return ' ';
    }

    public static void main(String[] args) {
        char c = new Solution50().findUniqueChar("abcdefgabcdefgh");
        System.out.println(c);
    }
}
