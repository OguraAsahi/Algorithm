package offer;

/**
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。
 *
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 */
public class Solution10 {
    public int fib(int n) {
        int a = 0, b = 1;
        for (int i = 0; i < n; ++i) {
            int c = (a + b) % 1000000007;
            a = b;
            b = c;
        }
        return a;
    }

    public static void main(String[] args) {
        int n = 10;
        int fib = new Solution10().fib(n);
        System.out.println(fib);
    }
}
