package offer;

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
