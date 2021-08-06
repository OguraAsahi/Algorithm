package demo01_dynamic_programming.Demo02_排队买票问题;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/*
    需求:
    一场演唱会即将举行。现有𝑛个歌迷排队买票，一个人买一张，而售票处规定，
    一个人每次最多只能买两张票。假设第𝑖位歌迷买一张票需要时间𝑇𝑖（1≤𝑖≤𝑛），
    队伍中相邻的两位歌迷（第𝑗个人和第𝑗+1个人）也可以由其中一个人买两张票，
    而另一位就可以不用排队了，则这两位歌迷买两张票的时间变为𝑅𝑗，假如
    𝑅𝑗<𝑇𝑗+𝑇𝑗+1，这样做就可以缩短后面歌迷等待的时间，加快整个售票的进程。
    现给出𝑛, 𝑇𝑗和𝑅𝑗，求使每个人都买到票的最短时间和方法。
 */
public class Demo02_排队买票问题 {
    public static void main(String[] args) throws IOException {
        BuyTickets();
    }

    private static void BuyTickets() throws IOException {
        int n = 10;
        /*Scanner sc = new Scanner(System.in);
        n = sc.nextInt();*/
        /*int[] T = {0,1,2,1,3,4,5};
        int[] R = {0,2,2,3,5,8};*/
        int[] T = new int[n+5];
        int[] R = new int[n+5];
        read_by_array(T, R, n);

        /*for (int i = 1; i < n+1; i++) {
            T[i] = sc.nextInt();
        }
        for (int i = 1; i < n; i++) {
            R[i] = sc.nextInt();
        }*/

        int[] f = new int[n+5];
        f[0] = 0;
        f[1] = T[1];
        for (int i = 2; i <= n; i++) {
            f[i] = Math.min(f[i - 2] + R[i - 1], f[i - 1] + T[i]);
        }
        System.out.println("最少的排队时间为:" + f[n] + "小时");
    }

    private static void read_by_array(int[] T, int[] R, int n) throws IOException {
        FileInputStream fis1 = new FileInputStream("hust-oj\\src\\demo01_dynamic_programming\\Demo02_排队买票问题\\T.txt");
        int len = 0; //记录每次读取的有效字符个数
        byte[] bytes = new byte[1024];
        while ((len = fis1.read(bytes)) != -1) {
            String[] split = new String(bytes, 0, len).split("\r\n");
            for (int i = 1; i <= n; i++) {
                T[i] = Integer.parseInt(split[i -1]);
            }
        }
        FileInputStream fis2 = new FileInputStream("hust-oj\\src\\demo01_dynamic_programming\\Demo02_排队买票问题\\R.txt");
        len = 0; //记录每次读取的有效字符个数
        byte[] bytes2 = new byte[1024];
        while ((len = fis2.read(bytes)) != -1) {
            String[] split = new String(bytes, 0, len).split("\r\n");
            for (int i = 1; i < n; i++) {
                R[i] = Integer.parseInt(split[i -1]);
            }
        }
        fis1.close();
        fis2.close();
    }
}
