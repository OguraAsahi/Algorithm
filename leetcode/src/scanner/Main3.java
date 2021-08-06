package scanner;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main3 {

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
