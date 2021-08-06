package offer;

/**
 *请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 */

// 一般使用replace方法即可
// 若手写的话, 则先需要统计空格的数量, 然后创建一个新字符数组, 大小为length + flag * 2
// 然后从后往前遍历原数组, 当遇到空格时, 将空格依次赋值, 若未遇到空格, 则将原数组加到新数组中
public class Solution05 {
    public char[] replaceAll(char[] str){
        int length = str.length;
        int flag = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == ' '){
                ++flag;
            }
        }
        if (flag == 0){
            return str;
        }
        int j = length - 1 + flag * 2;
        char[] newStr = new  char[j + 1];
        for (int i = length - 1; i >= 0; i--){
            if (str[i] == ' '){
                newStr[j] = '0';
                newStr[--j] = '2';
                newStr[--j] = '%';
                --j;
            }else {
                newStr[j] = str[i];
                --j;
            }
        }
        return newStr;
    }

    public static void main(String[] args) {
        char[] str = " We are happy ".toCharArray();
        System.out.println(str);
        System.out.println(new Solution05().replaceAll(str));
    }
}
