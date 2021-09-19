package scanner.huawei;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * 第一题 反转每对括号间的子串
 * 题目
 * 给出一个字符串s（仅包含小写英文字母和括号），请你按照从内层到外层的顺序，逐层反转每对匹配括号内包含的字符串，并返回最终的结果。
 *
 * 输入描述：输入为一行带有括号的字符串
 * 输出描述：反转括号内字符串并输出
 *
 * 示例：(u(love)i) 经过内层括号翻转变成(uevoli)，再经过翻转得到iloveu。
 *
 * 解析
 * 实现思路： 以 abc(u(love)i)ab 为例，从左向右遍历字符串时，会出现括号里有括号的情况。
 * 对于里面的括号(love)，显然要先翻转，然后再与前面的u合并；再处理外面的括号(u(love)i)，再与前面的abc结合。这实现前面的这两步，必然需要用到栈。
 */
public class Main1 {
    public static String reserveString(String s){
        if (s == null){
            return null;
        }
        char[] chars = s.toCharArray();
        Deque<Integer> stack = new ArrayDeque<>();
        int n = chars.length;
        if (n == 0){
            return null;
        }
        for (int i = 0; i < n; i++) {
            if (chars[i] == '('){
                stack.push(i);
            } else if (chars[i] == ')'){
                int l = stack.pop() + 1, r = i - 1;
                while (l < r){
                    char t = chars[l];
                    chars[l] = chars[r];
                    chars[r] = t;
                    l++;
                    r--;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (chars[i] != '(' && chars[i] != ')'){
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String result = reserveString(s);
        System.out.println(result);
    }
}
