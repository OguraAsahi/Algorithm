package scanner;

import java.util.Scanner;

public class Main2 {

    private static long min(long n, long k){
        long res = 0;
        char[] chars = String.valueOf(n).toCharArray();
        int length = chars.length;
        if (length == 0){
            return 0;
        }
        int i = 0;
        while (k > 0){
            int min = i;
            for (int j = i; j < length; j++) {
                if (min == 0 && chars[j] == '0'){
                    continue;
                }
                if (chars[j] < chars[min]){
                    min = j;
                }
            }
            if (i >= length){
                return Long.parseLong(String.valueOf(chars));
            }
            swap(chars, min, i);
            if (min != i){
                k--;
            }
            i++;
        }
        res = Long.parseLong(String.valueOf(chars));
        return res;
    }

    private static void swap(char[] chars, int i, int j){
        if (j == 0 && chars[i] == '0'){
            return;
        }
        char t = chars[i];
        chars[i] = chars[j];
        chars[j] = t;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n;
        n = in.nextInt();
        long[] res = new long[n];
        long[] a = new long[n];
        long[] b = new long[n];
        int i = 0;
        while (n-- > 0){
            a[i] = in.nextLong();
            b[i] = in.nextLong();
            i++;
        }
        for (int j = 0; j < i; j++) {
            System.out.println(min(a[j], b[j]));
        }
    }
}
