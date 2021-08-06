package scanner;

import java.util.Scanner;

public class Main7 {

    private static int MaxNum(int[] nums, int n, int k){
        long[] dp = new long[n];
        for (int i = 0; i < k; i++) {
            dp[0] += nums[i];
        }
        if (n == k){
            return 1;
        }

        for (int i = 1; i < n; i++) {
            if (i + k <= n){
                dp[i] = dp[i - 1] + nums[i + k - 1] - nums[i - 1];
            } else {
                dp[i] = dp[i - 1] + nums[(i + k - 1) % n] - nums[i - 1];
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            System.out.println(dp[i]);
            if (dp[i] > dp[max]){
                max = i;
            }
        }
        return max + 1;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        int i = MaxNum(nums, n, k);
        System.out.println(i);
    }
}
