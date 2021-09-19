package scanner.bigo;

import java.util.*;

public class Main3 {

    public static String getLevelByQuotaPolicy(Map<Integer, String> priorityNumber2Name,
                                               int cpuUsed, int quotaLimit, String originalLevel){

        Set<Integer> keySet = priorityNumber2Name.keySet();
        Iterator<Integer> it = keySet.iterator();
        int[] nums = new int[priorityNumber2Name.size()];
        int num = 0, flag = 0;
        int interval = (int) (quotaLimit * 0.5);
        String ret = "";
        int i = 0;
        while (it.hasNext()){
            Integer next = it.next();
            nums[i] = next;
            i++;
        }
        Arrays.sort(nums);
        for (int j = 0; j < nums.length; j++) {
            if (priorityNumber2Name.get(nums[j]) == originalLevel){
                num = nums[j];
                flag = j;
                break;
            }
        }

        if (cpuUsed < quotaLimit){
            return originalLevel + "(" + num + ")";
        } else {
            do {
                if (flag == 0){
                    return priorityNumber2Name.get(num) +"(" + num + ")";
                }
                flag--;
                num = nums[flag];
                ret = priorityNumber2Name.get(num) +"(" + num + ")";
                cpuUsed -= interval;
            } while (cpuUsed > quotaLimit);
        }
        return ret;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Map<Integer, String> priorityNumber2Name = new HashMap<>();
        priorityNumber2Name.put(5, "A");
        priorityNumber2Name.put(6, "B");
        priorityNumber2Name.put(7, "C");
        priorityNumber2Name.put(8, "D");
        String s = getLevelByQuotaPolicy(priorityNumber2Name, 299, 100, "D");
        System.out.println(s);
    }
}
