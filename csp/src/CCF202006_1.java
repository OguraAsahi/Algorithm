import java.util.Scanner;

public class CCF202006_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] data = new int[n][2];
        char[] type = new char[n];
        for (int i = 0; i < n; i++) {
            data[i][0] = sc.nextInt();
            data[i][1] = sc.nextInt();
            type[i] = sc.next().charAt(0);
        }

        int[] line = new int[3];
        boolean[] results = new boolean[m];
        //判断A类型是否指点在直线上方,是则up等于true
        boolean up = true;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 3; j++) {
                line[j] = sc.nextInt();
            }
            int result = line[0] + (line[1] * data[0][0]) + (line[2] * data[0][1]);
            if (type[0] == 'A' && result > 0){
                up = true;
            } else if (type[0] == 'B' && result < 0){
                up = true;
            } else {
                up = false;
            }

            for (int j = 0; j < n; j++) {
                result = line[0] + (line[1] * data[j][0]) + (line[2] * data[j][1]);
                if (up) {
                    if (type[j] == 'A' && result > 0){
                        results[i] = true;
                    } else if (type[j] == 'A' && result < 0){
                        results[i] = false;
                        break;
                    } else if (type[j] == 'B' && result < 0){
                        results[i] = true;
                    } else if (type[j] == 'B' && result > 0) {
                        results[i] = false;
                        break;
                    }
                } else {
                    if (type[j] == 'A' && result < 0){
                        results[i] = true;
                    } else if (type[j] == 'A' && result > 0){
                        results[i] = false;
                        break;
                    } else if (type[j] == 'B' && result > 0){
                        results[i] = true;
                    } else if (type[j] == 'B' && result < 0) {
                        results[i] = false;
                        break;
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            if (results[i])
                System.out.println("Yes");
            else
                System.out.println("No");
        }
    }
}
