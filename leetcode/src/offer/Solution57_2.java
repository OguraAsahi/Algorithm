package offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 *
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 */
public class Solution57_2 {
    public int[][] findContinuousSequence(int target){
        List<int[]> list = new ArrayList<>();
        int p = 1, q = 2;
        while (p < q){
            // 求和表达式, p + q为首尾, q - p + 1为p到q有多少个数, 最后除以2
            int s = (p + q) * (q - p + 1) >> 1;
            if (s == target){
                int[] t = new int[q - p + 1];
                for (int i = 0; i < t.length; i++) {
                    t[i] = p + i;
                }
                list.add(t);
                ++p;
            } else if (s < target){
                ++q;
            } else {
                ++p;
            }
        }
        int[][] res = new int[list.size()][];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] nums = new Solution57_2().findContinuousSequence(15);
        for (int[] i : nums){
            for (int num : i) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
