package offer;

/**
 * 输入一个整数 n ，求 1 ～ n 这 n 个整数的十进制表示中 1 出现的次数。
 *
 * 例如，输入 12，1 ～ 12 这些整数中包含 1 的数字有 1、10、11 和 12，1 一共出现了 5 次。
 */
public class Solution43 {
    // f(n)表示从1 ~ n当中数位1出现的个数
    // 以n = 3356为例
    // 0~999 范围内 1 的个数为 f(base-1)
    // 1000~1999 范围内 1 的个数可分为两部分：千位、其余位。千位都为 1，所以 1 的个数为 base+f(base-1)
    // 2000~2999 范围内 1 的个数为 f(base-1)
    // 3000~3356 范围内 1 的个数为 f(lows)

    // 以n = 1356为例
    // 0~999 范围内 1 的个数为 f(base-1)
    // 1000~1356 范围内 1 的个数为 lows + 1 + f(lows)
    public int countDigitOne(int n){
        if (n < 1){
            return 0;
        }
        String s = String.valueOf(n);
        int high = s.charAt(0) - '0';
        int base = (int)Math.pow(10, s.length() - 1);
        int lows = n % base;
        return high == 1 ? countDigitOne(base - 1) + countDigitOne(lows) + lows + 1
                : high * countDigitOne(base - 1) + countDigitOne(lows) + base;
    }

    public static void main(String[] args) {
        int i = new Solution43().countDigitOne(13);
        System.out.println(i);
    }
}
