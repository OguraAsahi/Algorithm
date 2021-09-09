package scanner.xiaomi.before;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 题目描述：
 * 有A、B两个有序数组，将B合并到A中。合并之后输出结果，以空格隔开
 * 说明：
 * （1）初始化A和B的元素数量分别为m和n
 * （2）A有足够的空间来保存B中的元素
 * （3）默认升序
 */
public class Main {

    public int[] solution(int[] A, int[] B){
        int m = A.length, n = B.length;
        int i = 0, a = 0, b = 0;
        int[] t = new int[m + n];
        while (a < m && b < n){
            if (A[a] < B[b]){
                t[i++] = A[a++];
            } else {
                t[i++] = B[b++];
            }
        }
        while (a < m){
            t[i++] = A[a++];
        }
        while (b < n){
            t[i++] = B[b++];
        }
        return t;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int[] solution = new Main().solution(new int[]{1, 2, 3, 7, 10}, new int[]{4, 5, 6, 8, 9, 11});
        Arrays.stream(solution).forEach(System.out :: print);
    }
}
