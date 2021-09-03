package offer;

/**
 * 请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。
 *
 * 例如，把 9  表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
 */
public class Solution15 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            n &= (n - 1);
            ++res;
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 2147483647;
        int res = new Solution15().hammingWeight(n);
        System.out.println(res);
    }
}
