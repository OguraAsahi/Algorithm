package scanner.xiaomi;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main2 {
    public int solution(String str1, String str2){
        HashMap<Integer, Integer> map = new HashMap<>();
        int m = str1.length(), n = str2.length();
        int[] dp = new int[Math.min(m, n) + 1];
        int maxLen = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (str1.charAt(i) == str2.charAt(j)){
                    map.put(i, j);
                    int flag = i;
                    while (flag > 0){
                        if (!map.containsKey(flag)){
                            flag--;
                            continue;
                        }
                        if (map.get(flag) < j){
                            dp[i + 1] = dp[flag] + 1;
                            break;
                        }
                        flag--;
                    }
                    break;
                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String str1 = in.nextLine();
        String str2 = in.nextLine();
        int len = new Main2().solution(str1, str2);
        System.out.println(len);
    }
}
