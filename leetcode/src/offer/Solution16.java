package offer;

/**
 * 实现函数 double Power(double base, int exponent)，求 base 的 exponent 次方。不得使用库函数，同时不需要考虑大数问题。
 */
public class Solution16 {
    // 利用递归来求一个数的整数次方, n可能为负数
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        if (n == -1) return 1 / x;
        // 利用二分来提高效率, 同时return的时候判断指数是否是奇数
        double half = myPow(x, n / 2);
        return half * half * myPow(x, n % 2);
    }

    public static void main(String[] args) {
        double v = new Solution16().myPow(4, -2);
        System.out.println(v);
    }

}
