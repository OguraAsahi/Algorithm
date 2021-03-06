package scanner.huawei;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.Stack;

public class Main4 {


    public static String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (']' == c) {
                StringBuilder stringBuilder = new StringBuilder();
                while(!stack.peek().equals("[")) {
                    stringBuilder.insert(0, stack.pop());
                }
                stack.pop();
                Integer times = Integer.valueOf(stack.pop());
                StringBuilder temp = new StringBuilder();
                for (int j = 0; j < times; j++) {
                    temp.append(stringBuilder);
                }
                stack.push(temp.toString());
            } else if (c >= '0' && c <= '9'){
                StringBuilder stringBuilder = new StringBuilder();
                while (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    stringBuilder.append(s.charAt(i));
                    i++;
                }
                i--;
                stack.push(stringBuilder.toString());
            } else {
                stack.push(s.substring(i, i + 1));
            }
        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }
        return result.toString();
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String decode = decodeString(s);
        System.out.println(decode);
    }
}
