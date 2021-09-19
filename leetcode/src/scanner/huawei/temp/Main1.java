package scanner.huawei.temp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 最长严格上升子序列
 */
public class Main1 {

    public static int solution(int[] nums){
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int maxLen = 0;
        for (int i = 0; i < dp.length; i++) {
            maxLen = Math.max(dp[i], maxLen);
        }
        return maxLen;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int solution = solution(new int[]{0, 1, 0, 3, 2, 3});
        System.out.println(solution);
    }
}
