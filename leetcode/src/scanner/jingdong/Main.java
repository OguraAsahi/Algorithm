package scanner.jingdong;

import java.util.Scanner;

public class Main {

    public void solution(int n, int m, int x, int y, int z, String[] matrix, String str){
        int cur_row = 0, cur_col = 0;
        long sum = 0;
        for (int i = 0; i < str.length(); i++) {
            char target = str.charAt(i);
            int row = 0, col = 0;
            long cost = 0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < matrix[j].length(); k++) {
                    if (target == matrix[j].charAt(k)){
                        row = j;
                        col = k;
                    }
                }
            }
            if (cur_row != row && cur_col != col){
                cost += y;
            }
            cost += (Math.abs(cur_row - row) + Math.abs(cur_col - col)) * x;
            cost += z;
            cur_row = row;
            cur_col = col;
            sum += cost;
        }
        System.out.println(sum);
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String num = in.nextLine();
        //String num = "2 2 1 1 1";
        String[] s = num.split(" ");
        int n, m, x, y, z;
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        x = Integer.parseInt(s[2]);
        y = Integer.parseInt(s[3]);
        z = Integer.parseInt(s[4]);
        String[] matrix = new String[n];
        for (int i = 0; i < n; i++) {
            matrix[i] = in.nextLine();
        }
        //matrix[0] = ".E";
        //matrix[1] = ":F";
        String str = in.nextLine();
        //String str = "EE:F.:";
        new Main().solution(n,m,x,y,z,matrix,str);
    }
}
