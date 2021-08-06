package offer;

import java.util.Arrays;

public class Solution45 {
    public String minNumber(int[] nums){
        if (nums == null || nums.length == 0){
            return null;
        }
        // 将数组转换为数据流, 然后将数据流转换字符串, 对字符串进行排序
        String s = Arrays.stream(nums).mapToObj(String::valueOf).sorted((s1, s2) -> (s1 + s2).compareTo(s2 + s1)).reduce((s1, s2) -> (s1 + s2)).get();
        System.out.println(s);
        return s;
    }

    public static void main(String[] args) {
        int[] nums = {1,101,202};
        String rs = new Solution45().minNumber(nums);
    }

}
