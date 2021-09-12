package scanner.xiaomi;

import java.util.Scanner;

/**
 * 最长公共子序列
 */
public class Main2 {
    public int solution(String str1, String str2){
        int m = str1.length(), n = str2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String str1 = in.nextLine();
        String str2 = in.nextLine();
        int len = new Main2().solution(str1, str2);
        System.out.println(len);
    }
}
