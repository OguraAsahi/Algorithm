package scanner;

import java.util.Scanner;

public class Main8 {

    private static int fish(int[] a, long[] cost, int n, long w, long b, long x) {
        int res = 0;
        long strength = w;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            if (b > cost[i]){
                res += a[i];
                continue;
            }
            
        }
        return res;
    }


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long w = in.nextLong(), b = in.nextLong(), x = in.nextLong();
        int[] a = new int[n];
        long[] cost = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            cost[i] = in.nextLong();
        }
        int fish = fish(a, cost, n, w, b, x);
        System.out.println(fish);
    }
}
