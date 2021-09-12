package hot.dp;

/**
 * 最大子串和
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums){
        int n;
        if ((n = nums.length) == 0){
            return 0;
        }
        int f = nums[0], res = nums[0];
        for (int i = 1; i < n; i++) {
            f = nums[i] + Math.max(f, 0);
            res = Math.max(res, f);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,-7,5,6,7,-16};
        int i = new MaxSubArray().maxSubArray(nums);
        System.out.println(i);
    }
}
