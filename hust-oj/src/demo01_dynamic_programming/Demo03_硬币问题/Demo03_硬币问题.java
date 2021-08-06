package demo01_dynamic_programming.Demo03_硬币问题;

import java.util.Scanner;

/*
    需求:
        如果我们有面值为1元、5元和11元的硬币足够多，如何用最少的硬币凑够103元？(11枚）
        如果我们有面值为𝑎1<𝑎2<…<𝑎𝑛元的硬币足够多，如何用最少的硬币凑够𝑀元？(如何初始化？)
        f(i) = min{f(i - aj) | aj <= i} + 1, (i>0),同时需要构造i < an时的初始函数
 */
public class Demo03_硬币问题 {
    public static void main(String[] args) {
        coin();
    }

    private static void coin() {
        int n = new Scanner(System.in).nextInt();
        int[] f = new int[n+1];
        // 初始化
        for (int i = 1; i <= n; i++) {
            if (i > 11)
                f[i] = Math.min(f[i-1], Math.min(f[i-5], f[i-11])) + 1;
            else if (i == 1 || i == 5 || i == 11)
                f[i] = 1;
            else if(i <5)
                f[i] = i;
            else if(i < 10)
                f[i] = i - 4;
            else
                f[i] = 2;
        }
        System.out.println("最少需要" + f[n] + "枚硬币才能凑够n元");

    }
}
