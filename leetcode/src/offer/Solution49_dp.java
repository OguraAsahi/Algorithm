package offer;

public class Solution49_dp {
    public int nthUglyNumber(int n){
        int[] dp = new int[n];
        dp[0] = 1;
        int i2 = 0, i3 = 0, i5 = 0;
        for (int i = 1; i < n; i++) {
            int next2, next3, next5;
            // 这里是乘以dp[i]而不是乘以i, 乘以i会引入非2,3,5的因子
            next2 = 2 * dp[i2];
            next3 = 3 * dp[i3];
            next5 = 5 * dp[i5];
            dp[i] = Math.min(Math.min(next2, next3), next5);
            if (dp[i] == next2){
                ++i2;
            }
            if (dp[i] == next3){
                ++i3;
            }
            if (dp[i] == next5){
                ++i5;
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int i = new Solution49_dp().nthUglyNumber(10);
        System.out.println(i);
    }
}
