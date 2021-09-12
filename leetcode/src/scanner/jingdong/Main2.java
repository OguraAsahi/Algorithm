package scanner.jingdong;

import java.util.*;

public class Main2 {
    boolean[] status;
    int survive;

    public void solution(HashMap<Integer, Set<Integer>> map, String[] request){
        int option, num;
        status = new boolean[map.size() + 1];
        Arrays.fill(status, false);
        survive = 0;
        for (int i = 1; i <= map.size(); i++) {
            Set<Integer> dependency = map.get(i);
            Iterator<Integer> iterator = dependency.iterator();
            while (iterator.hasNext()){
                Integer target = iterator.next();
                Set<Integer> second = map.get(target);
                helper(map, dependency, second);
            }
            map.put(i, dependency);
        }


        for (int i = 0; i < request.length; i++) {
            String[] s= request[i].split(" ");
            option = Integer.parseInt(s[0]);
            num = Integer.parseInt(s[1]);
            Set<Integer> dependency = map.get(num);
            Iterator<Integer> iterator = dependency.iterator();
            while (iterator.hasNext()){
                Integer target = iterator.next();
                if (status[target] == false && option == 1){
                    status[target] = true;
                    survive++;
                }
            }
            if (status[num] == false && option == 1){
                status[num] = true;
                survive++;
            } else if (status[num] == true && option == 0){
                status[num] = false;
                survive--;
                close(map, num);
            }
            System.out.println(survive);
        }
    }

    private void helper(HashMap<Integer, Set<Integer>> map, Set<Integer> total_dependency, Set<Integer> dependency){
        Iterator<Integer> iterator1 = dependency.iterator();
        while (iterator1.hasNext()){
            Integer next = iterator1.next();
            if (!total_dependency.contains(next)){
                total_dependency.add(next);
                helper(map, total_dependency, map.get(next));
            }
        }
    }

    private void close(HashMap<Integer, Set<Integer>> map, int target){
        for (int i = 1; i <= map.size(); i++) {
            Set<Integer> set = map.get(i);
            if (set.contains(target) && status[i]){
                status[i] = false;
                survive--;
                close(map, i);
            }
        }
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n, q;
/*        String firstLine = in.nextLine();
        String[] split = firstLine.split(" ");
        n = Integer.parseInt(split[0]);
        q = Integer.parseInt(split[1]);*/
        n = 3;
        q = 2;
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
/*        for (int i = 1; i <= n; i++) {
            Set<Integer> set = new HashSet<>();
            String str = in.nextLine();
            String[] s = str.split(" ");
            int cnt = Integer.parseInt(s[0]);
            for (int j = 1; j <= cnt; j++) {
                set.add(Integer.parseInt(s[j]));
            }
            map.put(i, set);
        }*/
         HashSet<Integer> set1 = new HashSet<>();
         HashSet<Integer> set2 = new HashSet<>();
         HashSet<Integer> set3 = new HashSet<>();
         set1.add(2);
         set2.add(3);
         set3.add(1);
         map.put(1, set1);
         map.put(2, set2);
         map.put(3, set3);

        String[] request = new String[q];
/*        for (int i = 0; i < q; i++) {
            request[i] = in.nextLine();
        }*/
        request[0] = "1 1";
        request[1] = "0 2";
        new Main2().solution(map, request);
    }
}
