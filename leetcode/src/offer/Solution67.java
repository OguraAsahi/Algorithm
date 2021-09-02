package offer;

/**
 * 写一个函数 StrToInt，实现把字符串转换成整数这个功能。不能使用 atoi 或者其他类似的库函数。
 *
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
 *
 * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 *
 * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
 *
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
 *
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
 */
public class Solution67 {
    public int strToInt(String str){
        int n;
        if (str == null || (n = str.length()) == 0){
            return 0;
        }
        int i = 0;
        while(str.charAt(i) ==' '){
            // 仅包含空格
            if (++i == n){
                return 0;
            }
        }
        int sign = 1;
        if (str.charAt(i) == '-'){
            sign = -1;
        }
        if (str.charAt(i) == '-' || str.charAt(i) == '+'){
            ++i;
        }
        int res = 0, flag = Integer.MAX_VALUE / 10;
        for (; i < n; ++i){
            // 非数字, 跳出循环体
            if (str.charAt(i) < '0' || str.charAt(i) > '9'){
                break;
            }
            // 溢出判断
            if (res > flag || (res == flag) && str.charAt(i) > '7'){
                return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + (str.charAt(i) - '0');
        }
        return sign * res;
    }

    public static void main(String[] args) {
        int i = new Solution67().strToInt("  -9876543  eqweqw");
        System.out.println(i);
    }
}
