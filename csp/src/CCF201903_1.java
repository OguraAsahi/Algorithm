import java.util.Scanner;

public class CCF201903_1 {
    public static void main(String[] args) {
        int n, max, min;
        double middle = 0.0;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] l = new int[n + 1];
        for (int i = 0; i < n; i++) {
            l[i] = sc.nextInt();
        }
        max = Math.max(l[n - 1], l[0]);
        min = Math.min(l[n - 1], l[0]);

        if (n % 2 != 0) {
            middle = l[(n - 1) / 2];
            System.out.print(max + " " + (int) middle + " " + min);
        } else {
            double sum = 0.0;
            sum = l[n / 2] + l[n / 2 - 1];
            middle = sum / 2;
            if ((middle - (int) middle) == 0) {
                System.out.print(max + " " + (int) middle + " " + min);
            } else {
                System.out.print(max + " " + middle + " " + min);
            }
        }
    }
}
