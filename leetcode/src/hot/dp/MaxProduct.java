package hot.dp;

public class MaxProduct {
    public int maxProduct(int[] nums){
        int maxf = nums[0], minf = nums[0];
        int res = nums[0], n = nums.length;
        for (int i = 1; i < n; i++) {
            int p = maxf, q = minf;
            maxf = Math.max(Math.max(nums[i], p * nums[i]), q * nums[i]);
            minf = Math.min(Math.min(nums[i], p * nums[i]), q * nums[i]);
            res = Math.max(maxf, res);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,-6, 72, 2, 1};
        int i = new MaxProduct().maxProduct(nums);
        System.out.println(i);
    }
}
