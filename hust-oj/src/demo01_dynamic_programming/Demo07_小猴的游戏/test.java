package demo01_dynamic_programming.Demo07_小猴的游戏;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n,d;
        String str1 = input.nextLine();
        String[] s1 = str1.split(" ");
        n = Integer.parseInt(s1[0]);
        d = Integer.parseInt(s1[1]);
        String str = input.nextLine();
        String[] s = str.split(" ");
        int[] h = new int[n + 1];
        for(int i=0; i<n; i++) {
            h[i] = Integer.parseInt(s[i]);
        }
        int[] dis = new int[n];
        int[] pre = new int[n];
        for (int i = 0; i < n; i++) {
            dis[0] = 1;
            pre[0] = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (Math.abs(h[i] - h[j]) >= d && dis[j]+1 > dis[i]){
                    pre[i] = j;
                    dis[i] = dis[j] + 1;
                }
            }
        }
        int max = 1;
        for (int i = 0; i < n; i++){
            if (dis[i] > max)
                max = dis[i];
        }
        System.out.println(max);
    }
}
