package offer;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 */
public class Solution39 {

    // 摩尔投票法, 适用于某个元素占数组一半及以上的情况
    public int majorityElement(int[] nums){
        int major = 0, cnt = 0;
        for (int num : nums) {
            if (cnt == 0){
                major = num;
                cnt++;
            } else {
                cnt += (num == major ? 1 : -1);
            }
        }
        return major;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 3, 3, 3, 2, 2, 2, 2, 2};
        int major = new Solution39().majorityElement(nums);
        System.out.println(major);
    }
}
