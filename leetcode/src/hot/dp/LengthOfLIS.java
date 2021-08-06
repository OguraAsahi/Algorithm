package hot.dp;

import java.util.Arrays;

public class LengthOfLIS {
    private int lengthOfLIS(int[] nums){
        int n;
        if (nums == null || (n = nums.length) == 0){
            return 0;
        }
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 1; i < n; i++) {
            // 定义 dp[i] 为以 nums[i] 结尾的最长子序列的长度。即题目求的是 dp[i] （i ∈[0, n-1]）的最大值。
            // 每轮循环找出nums[i]的最大子序列长度
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
