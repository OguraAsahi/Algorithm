package hot.math;

import java.util.ArrayList;

public class Yanghui_triangle {
    public static ArrayList<Integer> solution(int n){
        ArrayList<Integer> res = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(1);
        if (n == 0){
            return temp;
        }
        for (int i = 1; i <= n; i++) {
            res = new ArrayList<>();
            res.add(1);
            for (int j = 1; j < i; j++) {
                res.add(temp.get(j - 1) + temp.get(j));
            }
            res.add(1);
            temp = res;
        }
        return res;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = solution(4);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}
