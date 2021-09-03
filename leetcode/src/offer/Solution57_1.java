package offer;

/**
 * 输入一个递增排序的数组和一个数字 s，在数组中查找两个数，使得它们的和正好是 s。如果有多对数字的和等于 s，则输出任意一对即可。
 */
public class Solution57_1 {
    public int[] twoSum(int[] nums, int target){
        int p = 0, q = nums.length - 1;
        while (p < q){
            int t = nums[p] + nums[q];
            if (t == target){
                return new int[]{nums[p], nums[q]};
            }else if (t < target){
                ++p;
            } else {
                --q;
            }
        }
        return new int[]{0};
    }

    public static void main(String[] args) {
        int[] nums = new Solution57_1().twoSum(new int[]{1, 2, 3, 4, 5, 6, 7}, 4);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
