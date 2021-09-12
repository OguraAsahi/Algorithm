package hot.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 最长不重复子串长度
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        int length = s.length();
        int[] dp = new int[length];
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        dp[0] = 1;
        int res = dp[0];
        map.put(chars[0], 0);
        for (int i = 1; i < length; i++) {
            if (chars[i] == chars[i - 1]){
                dp[i] = 1;
            } else if (map.get(chars[i]) == null){
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = Math.min(dp[i - 1] + 1, i - map.get(chars[i]));
            }
            map.put(chars[i], i);
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public int lengthOfLongestSubstring2(String s) {
        int res = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0, j = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            while (set.contains(c)) {
                set.remove(s.charAt(j++));
            }
            set.add(c);
            res = Math.max(res, i - j + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int length = new LengthOfLongestSubstring().lengthOfLongestSubstring("aabcdefggabcdfghjk");
        int length2 = new LengthOfLongestSubstring().lengthOfLongestSubstring2("aabcdefggabcdfghjk");
        System.out.println(length);
        System.out.println(length2);
    }
}
