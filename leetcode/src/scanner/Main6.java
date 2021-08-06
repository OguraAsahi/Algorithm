package scanner;

import java.util.*;

public class Main6 {

    private static int find(int n, HashMap<Integer, ArrayList<Integer>> map){
        HashSet<Integer> set = new HashSet<>();
        int sum = 0;
        Set<Integer> keySet = map.keySet();
        for (Integer i : keySet) {
            ArrayList<Integer> list = map.get(i);
            if (list.contains(n)){
                set.add(i);
            }
        }

        ArrayList<Integer> l = new ArrayList<>();

        for (Integer i : set) {
            l.add(i);
        }

        for (Integer i : l) {
            find2(i, map, set);
        }

        for (Integer i : set) {
            if (i != n) {
                sum += i;
            }
        }
        return sum;
    }

    private static void find2(int m, HashMap<Integer, ArrayList<Integer>> map, HashSet<Integer> set){
        Set<Integer> keySet = map.keySet();
        for (Integer i : keySet) {
            ArrayList<Integer> list = map.get(i);
            if (list.contains(m) && !set.contains(i)){
                set.add(i);
                find2(i, map, set);
            }
        }
    }


    public static void main(String[] args){
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int n = Integer.parseInt(str);
        while (!in.hasNext("#")){
            String s = in.nextLine();
            String[] split = s.split(",");
            ArrayList list = new ArrayList();
            int k = Integer.parseInt(split[0]);
            for (int i = 1; i < split.length; i++) {
                list.add(Integer.parseInt(split[i]));
            }
            if (!list.isEmpty()){
                map.put(k, list);
            }
        }
        int sum = find(n, map);
        if (sum == 0){
            System.out.println(-1);
            return;
        }
        System.out.println(sum);
    }
}
