package hot.dp;

import java.util.Arrays;

public class Robber_2 {
    private int robInternal(int[] nums){
        int n;
        if ((n = nums.length) == 0){
            return 0;
        }
        if (n == 1){
            return nums[0];
        }
        int pre = nums[0], cur = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            int t = cur;
            cur = Math.max(pre + nums[i], cur);
            pre = t;
        }
        return cur;
    }

    private int rob(int[] nums){
        int n;
        if (nums == null || (n = nums.length) == 0){
            return 0;
        }
        if (n == 1){
            return nums[0];
        }
        int sub1 = robInternal(Arrays.copyOfRange(nums, 0, n - 1));
        int sub2 = robInternal(Arrays.copyOfRange(nums, 1, n));
        return Math.max(sub1, sub2);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,2};
        int rob = new Robber_2().rob(nums);
        System.out.println(rob);
    }
}
