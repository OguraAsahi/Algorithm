package offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 */
public class Solution48_dp {
    public int lengthOfLongestSubstring(String s){
        if (s == null || "".equals(s)){
            return 0;
        }
        int n = s.length();
        char[] chars = s.toCharArray();
        // 维护一个dp数组, 记录每个位置的最长不重复子串的长度
        int[] dp = new int[n];
        int res = 1;
        // 用于记录最近的一个相同字符的位置
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put(chars[0], 0);
        for (int i = 1; i < n; i++) {
            // 如果该字符与前一个字符相同, 令该字符的dp值为1
            if (chars[i] == chars[i - 1]){
                dp[i] = 1;
            } else {
                // 如果之前未曾记录过该种字符, 则将其加入到map中, 并让该位置的dp值+1
                if (map.get(chars[i]) == null){
                    dp[i] = dp[i - 1] + 1;
                } else {
                    // 如果之前记录过这种字符, 则判断他前一个字符的dp值+1 和 上一次出现该字符到这一次出现的位置之差哪个更小
                    // 为什么要选较小的那个? 因为较小的那个必定不会有重复字符出现
                    // 当dp[i - 1] + 1较小时, 说明重复字符出现在现在的子串之前, 所以不会有差错
                    // 当i - map.get(chars[i])较小时, 显然较大的dp[i - 1] + 1 已经把重复字符包括进去了
                    dp[i] = Math.min(dp[i - 1] + 1, i - map.get(chars[i]));
                }
            }
            map.put(chars[i], i);
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int rs = new Solution48_dp().lengthOfLongestSubstring("abcbaacdb");
        System.out.println(rs);
    }
}
