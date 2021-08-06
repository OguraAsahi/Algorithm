import java.util.Scanner;

public class CCF201909_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /* t表示疏果后总果数, k表示疏果最多的树编号, p表示该树疏果的个数 */
        int n, m, t = 0, k = 0, p = 0, sum, a, b;
        /*  n表示树的个数, m表示每棵树要疏多少轮果, sum表示每棵树疏果后还剩下的果数, a表示累计疏果, b表示每轮要疏多少果 */
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            sum = sc.nextInt(); //疏果前总果数
            a = 0; // 累计疏果
            for (int j = 0; j < m; j++) {
                b = sc.nextInt();
                a += b;
            }
            if (-a > p){
                k = i + 1;
                p = -a;
            }
            t += a + sum;
        }
        System.out.println(t + " " + k + " " + p);
    }
}
