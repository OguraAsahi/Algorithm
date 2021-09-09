package scanner.meituan;

import java.util.Scanner;

/**
 * 题目描述
 * 小美天天刷题，收获了很多ac，为了纪念这些ac，小美记下了一个长度为n的仅有a和c组成的字符串。
 * 小团天天摸鱼不刷题，所以ac没有小美多。小团决定在小美睡觉的时候把小美字符串中的ac通过交换相邻两个字符全部消除。
 * 即通过一系列交换相邻字符的操作使得操作后的串中不存在ac这个字串。小团想知道他至少要交换多少次才能达成他的目的。
 *
 * 输入描述
 * 第一行有一个整数n(1<=n<=100000)，代表小美拥有的字符串长度
 * 第二行有一个仅由a和c组成的字符串，代表小美的字符串。
 *
 * 输出描述
 * 输出一个整数，代表小团知道的答案
 * 如样例acca中先交换前两个字符再交换中间两个字符即可使小美的字符串变成ccaa.
 */
public class Main3 {
    public int solution(int n, String str){
        int[] dp = new int[n + 1];
        char[] chars = str.toCharArray();
        int index_a = 0;
        if (chars[0] == 'a'){
            index_a = 1;
        }
        for (int i = 2; i <= n; i++) {
            if (chars[i - 1] == 'c' && chars[i - 2] == 'a'){
                // 遇到ac时, 要将c往前移, 但有可能又出现ac, 所以记录下前面的最后一个a, 总共移i - index_a次, 同时继承dp[i - 1]
                dp[i] = dp[i - 1] + i - index_a;
                index_a++;
                chars[i - 1] = 'a';
                chars[i - 2] = 'c';
            } else {
                if (chars[i - 1] == 'a' && index_a == 0){
                    // index_a = 0表示还没有出现过a
                    index_a = i;
                }
                dp[i] = dp[i - 1];
            }
        }
        return dp[n];
    }



    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String str = in.nextLine();
        int solution = new Main3().solution(n, str);
        System.out.println(solution);
    }
}
