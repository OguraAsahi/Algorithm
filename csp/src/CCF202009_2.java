import java.util.*;

public class CCF202009_2 {
    public static void main(String[] args) {
        int n, k, t, xl, yd, xr, yu;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        t = sc.nextInt();
        xl = sc.nextInt();
        yd = sc.nextInt();
        xr = sc.nextInt();
        yu = sc.nextInt();
        int pass = 0, stop = 0;
        for (int i = 0, x, y; i < n; i++) {
            int count = 0, maxcount = 0;
            for (int j = 0; j < k; j++) {
                x = sc.nextInt();
                y = sc.nextInt();
                count = (x < xl || x>xr || y < yd || y > yu) ? 0 : (count + 1);
                if (count > maxcount){
                    maxcount = count;
                }
            }
            if (maxcount > 0){
                pass++;
            }
            if (maxcount >= k){
                stop++;
            }
        }
        System.out.println(pass);
        System.out.println(stop);
    }
}
