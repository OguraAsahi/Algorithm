package offer;

/**
 * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 */
public class Solution65 {
    public int add(int a, int b) {
        while (b != 0) {
            // 对两数进行按位 ^ 异或运算，得到不进位的和；
            int s = a ^ b;
            // 对两数进行按位 & 与运算，然后左移一位，得到进位
            // 问题转换为求：“不进位的数 + 进位” 之和；
            // 循环，直至进位为 0，返回不进位的数即可（也可以用递归实现）
            b = (a & b) << 1;
            a = s;
        }
        return a;
    }

    public static void main(String[] args) {
        int sum = new Solution65().add(65536, 4);
        System.out.println(sum);
    }
}
