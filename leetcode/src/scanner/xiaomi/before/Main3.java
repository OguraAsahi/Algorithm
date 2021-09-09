package scanner.xiaomi.before;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 第一题：判断密码是否符合要求：
 * 给一系列密码：每个密码用空格分隔
 *（1）同时具有大写、小写、符号、数字输出0；
 *（2）长度不在8-120之间，输出1；
 *（3）类型不符合输出2
 */
public class Main3 {

    public int solution(String password){
        int n = password.length();
        if (n > 120 || n < 8){
            return 1;
        }
        char[] chars = password.toCharArray();
        boolean up = false, down = false, flag = false, num = false;
        for (int i = 0; i < n; i++) {
            if (chars[i] >= 'a' && chars[i] <= 'z'){
                down = true;
            } else if (chars[i] >= 'A' && chars[i] <= 'Z'){
                up = true;
            } else if (chars[i] >= '0' && chars[i] <= '9'){
                num = true;
            } else {
                flag = true;
            }
            if (up && down && flag && num){
                return 1;
            }
        }
        return 2;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
    }
}
