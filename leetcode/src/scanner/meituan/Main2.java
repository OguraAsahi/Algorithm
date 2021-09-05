package scanner.meituan;

import scanner.Main;

import java.util.Scanner;

public class Main2 {

    int[] dist = new int[510];
    boolean[] visited = new boolean[510];
    int[] a = new int[510];

    public int solution(int[][] matrix, int start, int end){
        int sum = 0;
        int n = matrix.length - 1, m = matrix[0].length - 1;
        for (int i = 1; i <= n; i++){
            dist[i] = matrix[1][i];
        }
        visited[1] = true;
        dist[1] = 0;
        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            int pos = start;
            for (int j = 1; j <= n; j++) {
                if (!visited[j] && dist[j] < min){
                    min = dist[j];
                    pos = j;
                }
            }
            visited[pos] = true;
            for (int j = 1; j <= n; j++) {
                if (!visited[j] && dist[j] > dist[pos] + matrix[pos][j]);
                {
                    dist[j] = dist[pos] + matrix[pos][j];
                }
            }
        }
        if (dist[end] == Integer.MAX_VALUE){
            return -1;
        } else {
            return dist[end] - 1;
        }
    }



    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] s1 = s.split(" ");
        int n = Integer.parseInt(s1[0]);
        int m = Integer.parseInt(s1[1]);
        int[][] matrix = new int[n + 1][m + 1];
        int[][] ret = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            int count = in.nextInt();
            String str = in.nextLine();
            String[] s2 = str.split(" ");
            for (int j = 1; j < count + 1; j++) {
                matrix[i][j] = Integer.parseInt(s2[j - 1]);
            }
        }
        Main2 main2 = new Main2();
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                System.out.print(main2.solution(matrix, i, j) + " ");
            }
            System.out.println();
        }
    }
}
