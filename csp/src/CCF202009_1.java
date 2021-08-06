
import java.util.*;

public class CCF202009_1 {
    public static void main(String[] args) {
        int n,x,y;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        x = sc.nextInt();
        y = sc.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0, xi, yi; i < n; i++) {
            xi = sc.nextInt();
            yi = sc.nextInt();
            int absX = Math.abs(xi - x);
            int absY = Math.abs(yi - y);
            int distance = absX * absX + absY * absY;
            map.put(i + 1, distance);
        }
        Collection<Integer> values = map.values();
        Object[] obj = values.toArray();
        Arrays.sort(obj);
        int[] temp = new int[3];
        for (int i = 0; i < 3; i++) {
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() == obj[i]){
                    temp[i] = entry.getKey();
                    map.remove(entry.getKey());
                    break;
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            System.out.println(temp[i]);
        }
    }
}
