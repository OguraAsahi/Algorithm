package offer;

/**
 * 从扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这 5 张牌是不是连续的。
 * 2 ～ 10 为数字本身，A 为 1，J 为 11，Q 为 12，K 为 13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 */
public class Solution61 {

    /**
     * 用数组 t 记录是否存在重复的数，存在则直接返回 false。
     *
     * 遍历数组，忽略大小王(0)，求出数组的最大、最小值。若最后差值超过 4，则无法构成顺子，例如：5,6,(0),8,10。
     */
    public boolean isStraight(int[] nums){
        boolean[] t = new boolean[14];
        int maxVal = Integer.MIN_VALUE;
        int minVal = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num == 0){
                continue;
            }
            if (t[num]){
                return false;
            }
            t[num] = true;
            maxVal = Math.max(num, maxVal);
            minVal = Math.min(minVal, num);
        }
        return maxVal - minVal <= 4;
    }
}
