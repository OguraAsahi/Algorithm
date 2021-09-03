package offer;

/**
 * 把 n 个骰子扔在地上，所有骰子朝上一面的点数之和为 s。输入 n，打印出 s 的所有可能的值出现的概率。
 *
 * 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
 */
public class Solution60_dp {

    /**
     * 扔 n 个骰子，点数之和的范围在 [n, 6n] 之间，总共有 5n+1 种，即为最后结果数组的长度。
     *
     * 假设 dp[i][j] 表示扔 i 个骰子，出现点数之和 j 的次数。n 个骰子，所以 i 的范围在 1~n，j 的范围在 [1, 6n]。
     */
    public double[] twoSum(int n){
        int[][] dp = new int[n + 1][6 * n + 1];
        for (int j = 1; j <= 6; j++) {
            dp[1][j] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = i; j < 6 * i; j++) {
                for (int k = 1; k <= 6 && j > k; ++k) {
                    dp[i][j] += dp[i - 1][j - k];
                }
            }
        }
        double[] res = new double[5 * n + 1];
        double all = Math.pow(6, n);
        for (int i = 0; i <= 5 * n; ++i) {
            res[i] = dp[n][n + i] * 1.0 / all;
        }
        return res;
    }
}
