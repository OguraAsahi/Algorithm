import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class CCF201909_2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n, m, T = 0, D = 0, E = 0, a1 = 0, a = 0;
        n = sc.nextInt();
        int[] flags = new int[n + 1];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            m = sc.nextInt();
            a1 = sc.nextInt();
            for (int j = 0; j < m - 1; j++) {
                a = sc.nextInt();
                if (a <= 0) {
                    a1 += a;
                } else if (a < a1) {
                    flags[i] += 1;
                    a1 = a;
                }
            }
            T += a1;
            map.put(i, flags[i]);
        }

        for (int i = 0; i < n; i++) {
            if (map.get(i) > 0) {
                D += 1;
                if (map.get((i + 1) % n) > 0 && map.get((i + 2) % n) > 0) {
                    E += 1;
                }
            }
        }
        System.out.println(T + " " + D + " " + E);
        sc.close();
    }
}
