package offer;

/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 *
 * 例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"0123"及"-1E-16"都表示数值，但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。
 *
 */
public class Solution20 {
    public boolean isNumber(String s) {
        if (s == null || s.trim().length() == 0) {
            return false;
        }
        // trim方法将字符串首尾的空格删掉
        char[] chars = s.trim().toCharArray();
        boolean findNum = false;
        boolean findE = false;
        boolean findDot = false;
        for (int i = 0, n = chars.length; i < n; ++i) {
            if (chars[i] == '+' || chars[i] == '-') {
                // 判断正负号出现的时机, 即开头和E/e的前面
                if (i != 0 && chars[i - 1] != 'e' && chars[i - 1] != 'E') {
                    return false;
                }
            } else if (chars[i] >= '0' && chars[i] <= '9') {
                // 判断出现的字符是否是数字, 已知不是正负号, 接下来还有可能是小数点和E/e
                findNum = true;
            } else if (chars[i] == '.') {
                // 如果小数点和E/e同时出现则说明不是数值
                if (findDot || findE) {
                    return false;
                }
                // 给小数点标记
                findDot = true;
            } else if (chars[i] == 'e' || chars[i] == 'E') {
                // 判断这次E/e之前是否出现过E/e或者没有发现数字
                // 也就是E/e只能出现一次并且前面带数字
                if (findE || !findNum) {
                    return false;
                }
                findE = true;
                findNum = false; // 确保e之后也出现数, 因为我们通过返回findNum作为结果
            } else {
                return false;
            }
        }
        return findNum;
    }

    public static void main(String[] args) {
        boolean result = new Solution20().isNumber("12e+5.4");
        System.out.println(result);

    }
}
