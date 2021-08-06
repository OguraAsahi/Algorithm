import java.util.*;

public class CCF201903_2 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        int[] array = new int[10];
        list.add(1);
        list.add(4);
        list.add(2);
        list.add(6);
        list.sort((o1, o2) -> o2 - o1);
        Stack<Integer> stack = new Stack<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<>();
        Set<Map.Entry<Integer, Integer>> entries = linkedHashMap.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        for (Integer integer : list) {
            System.out.println(integer);
        }

        Set<Integer> integers = new HashMap<Integer, Integer>().keySet();

    }
}
