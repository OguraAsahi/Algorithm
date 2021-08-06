package offer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution38 {
    private char[] chars;
    private List<String> res;

    public String[] permutation(String s){
        chars = s.toCharArray();
        res = new ArrayList<>();
        dfs(0);
        return res.toArray(new String[res.size()]);
    }

    public void dfs(int x){
        // 当x = length - 1时, 只有1种选择, 所以此时直接将chars加入到res并返回
        if (x == chars.length - 1){
            res.add(String.valueOf(chars));
            return;
        }
        Set<Character> set = new HashSet<Character>();
        // 第x位有length - x种排序情况
        for (int i = x; i < chars.length; ++i){
            // 若该字符已经出现过, 为了防止重复排序字符串出现, 直接跳过当前循环
            if (set.contains(chars[i])){
                continue;
            }
            // 当我们遇到未曾见过的字符时将其加入到set, 起到去重的效果
            set.add(chars[i]);
            // 通过swap演示第x位的length - x种排序情况
            swap(i, x);
            // 当我们选择了一种情况时, 开始对第x + 1位排序
            dfs(x + 1);
            // 递归结束记得还原
            swap(i, x);
        }
    }

    private void swap(int i, int j) {
        char t = chars[i];
        chars[i] = chars[j];
        chars[j] = t;
    }

    public static void main(String[] args) {
        String s = "aaac";
        String[] strings = new Solution38().permutation(s);
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
