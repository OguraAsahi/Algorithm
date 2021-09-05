package offer;

/**
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
 *
 * 一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 */
public class Solution46_dp {
    public int translateToNum(int num){
        return calc(String.valueOf(num));
    }

    public int calc(String s){
        int n = s.length();
        if (n < 2){
            return 1;
        }
        // y以11为例, 只有bb和l两种翻译
        int m = Integer.parseInt(s.substring(0, 2));
        // 当s的前两个字符可以不被拆分时, calc(s.substring(1))为拆分后的子串可能性, calc(s.substring(2))为不拆分后的子串可能性
        return m < 10 || m > 25 ? calc(s.substring(1)) : calc(s.substring(1)) + calc(s.substring(2));
    }

    public static void main(String[] args) {
        int i = new Solution46_dp().translateToNum(110);
        System.out.println(i);
    }
}
