package hot.string;

import java.util.HashMap;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        int length = s.length();
        int[] dp = new int[length];
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
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

    public static void main(String[] args) {
        int length = new LengthOfLongestSubstring().lengthOfLongestSubstring("aabcdefggabcdfghjk");
        System.out.println(length);
    }
}
