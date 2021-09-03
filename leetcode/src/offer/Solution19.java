package offer;

/**
 * 请实现一个函数用来匹配包含'. '和'*'的正则表达式。
 *
 * 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含 0 次）。
 *
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。
 */
public class Solution19 {
    public boolean isMatch(String s, String p) {
        int m = s.length() + 1, n = p.length() + 1;
        if (n == 1) {
            return m == 1;
        }
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        dp[0][1] = false;
        for (int j = 1; j < n; ++j) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    if (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') {
                        dp[i][j] = dp[i][j - 2] || dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i][j - 2];
                    }
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
