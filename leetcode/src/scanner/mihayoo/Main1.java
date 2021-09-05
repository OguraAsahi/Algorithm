package scanner.mihayoo;

import java.util.*;

public class Main1 {

    private ArrayList<String> res;

    public ArrayList<String> restoreIpAddresses (String ipStr) {
        res = new ArrayList<>();
        dfs(ipStr, new ArrayList<String>(), 0);
        return res;
    }

    private void dfs(String ipStr, ArrayList<String> temp, int cur){
        if (temp.size() == 4){
            StringBuilder sb = new StringBuilder();
            sb.append(temp.get(0) ).append(".").append(temp.get(1)).append(".").append(temp.get(2)).append(".").append(temp.get(3));
            res.add(sb.toString());
            return;
        }
        for (int i = cur; i < ipStr.length() && i < cur + 3; i++) {
            String sub;
            if (temp.size() == 3){
                sub = ipStr.substring(cur, ipStr.length());
            } else {
                sub = ipStr.substring(cur, i + 1);
            }
            if (Integer.parseInt(sub) <= 255){
                temp.add(sub);
                dfs(ipStr, temp, i + 1);
                temp.remove(temp.size() - 1);
                if (temp.size() == 3){
                    break;
                }
            } else {
                return;
            }
        }
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        ArrayList<String> list = new Main1().restoreIpAddresses(s);
        System.out.println(list.size());
    }
}
