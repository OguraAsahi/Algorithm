package demo01_dynamic_programming.Demo07_小猴的游戏;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Demo07_小猴的游戏 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n,d;
        String str1 = input.nextLine();
        String[] s1 = str1.split(" ");
        n = Integer.parseInt(s1[0]);
        d = Integer.parseInt(s1[1]);
        String str = input.nextLine();
        input.close();
        String[] s = str.split(" ");
        int[] h = new int[n + 1];
        for(int i=1; i<=n; i++) {
            h[i] = Integer.parseInt(s[i-1]);
            System.out.println(h[i]);
        }
        Integer[] result = new Integer[n+1];
        result[1] = h[1];
        int j = 1, k = 1;
        for (int i = 2; i <= n; i++){
            while (Math.abs(h[i] - h[i-1]) >= d){
                result[j]++;
                k++;
            }
            k++;
            i = k;
            j++;
        }
        Comparator cmp=new CMP();
        Arrays.sort(result, cmp);
        System.out.println(result[0]);
    }
}
class CMP implements Comparator<Integer>{
    public int compare(Integer a,Integer b){
//        两种都可以，升序排序的话反过来就行
//        return a-b<0?1:-1;
        return b-a;
    }
}
