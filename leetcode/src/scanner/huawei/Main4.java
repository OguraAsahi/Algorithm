package scanner.huawei;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.Stack;

public class Main4 {

    public static String decode(String s){
        char[] chars = s.toCharArray();
        int n = chars.length;
        StringBuilder sb = new StringBuilder();
        
        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i < n; i++) {
            if (chars[i] == '['){
                stack.push(i);
            } else if(chars[i] == ']'){
                int flag = stack.pop();
                int k = chars[flag - 1] - '0';
                int l = flag + 1;
                int r = i - 1;
                for (int j = 0; j < k; j++) {
                    for (int m = l; m <= r; m++) {
                        if (chars[m] != '[' && chars[m] != ']'){
                            sb.append(chars[m]);
                        }
                    }
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String decode = decode(s);
        System.out.println(decode);
    }
}
