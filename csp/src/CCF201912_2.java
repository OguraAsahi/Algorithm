import java.util.*;

public class CCF201912_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<HashMap<Integer, Integer>, Integer> map2 = new HashMap<>();
        int[] cnt = new int[5];
        for (int i = 0, x, y; i < n; i++) {
            HashMap<Integer, Integer> map = new HashMap<>();
            x = sc.nextInt();
            y = sc.nextInt();
            map.put(x, y);
            map2.put(map, 1);
        }
        Iterator<HashMap<Integer, Integer>> it1 = map2.keySet().iterator();
        HashMap<Integer, Integer> map;
        int count = 0;
        HashMap<Integer, Integer> temp1 = new HashMap<>();
        HashMap<Integer, Integer> temp2 = new HashMap<>();
        HashMap<Integer, Integer> temp3 = new HashMap<>();
        HashMap<Integer, Integer> temp4 = new HashMap<>();

        for (int i = 0, x, y; i < n; i++) {
            temp1.clear();
            temp2.clear();
            temp3.clear();
            temp4.clear();
            map = it1.next();
            x = map.keySet().iterator().next();
            y = map.get(x);
            temp1.put(x + 1, y);
            temp2.put(x - 1, y);
            temp3.put(x, y + 1);
            temp4.put(x, y - 1);
            if (map2.containsKey(temp1) && map2.containsKey(temp2) && map2.containsKey(temp3) && map2.containsKey(temp4)) {
                count = 0;
                temp1.clear();
                temp1.put(x + 1, y + 1);
                temp2.clear();
                temp2.put(x + 1, y - 1);
                temp3.clear();
                temp3.put(x - 1, y - 1);
                temp4.clear();
                temp4.put(x - 1, y + 1);
                if (map2.get(temp1) != null){
                    count++;
                }
                if (map2.get(temp2) != null)
                    count++;
                if (map2.get(temp3) != null)
                    count++;
                if (map2.get(temp4) != null)
                    count++;
                cnt[count]++;
            }
        }
        for (int i = 0; i <= 4; i++) {
            System.out.println(cnt[i]);
        }
    }
}
