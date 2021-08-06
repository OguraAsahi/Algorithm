package offer;

public class Solution62 {

    // 设f(n, m)表示从 n 个数中每次删除第 m 个，最后剩下的数字。
    // 则f(n, m) = ((m % n) + x) % n  当n减到1时, f(1, m)就是所求的值
    public int lastRemaining(int n, int m) {
        int f = 0;
        // 此处倒序的话更容易理解, 第一次模n求从n个数中删除第m个,
        // 第二次模n-1求从n-1个数中删除第m个, 但这次的起点要从上一次的终点后开始
        for (int i = 2; i <= n; ++i) {
            f = (f + m) % i;
        }
        return f;
    }
}
