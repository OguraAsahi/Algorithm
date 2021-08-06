package hot.dp;

public class Robber {
    public int robber(int[] nums){
        int n;
        if (nums == null || (n = nums.length) == 0){
            return 0;
        }
        if (n == 1){
            return nums[0];
        }
        int pre = nums[0];
        int cur = Math.max(nums[0], nums[1]);
        // 在连续三者之间选择, 是选cur还是pre + nums[i]
        // 之后将pre前进一位, cur变成cur和pre + nums[i]之间的较大值
        for (int i = 2; i < n; i++) {
            int t = Math.max(pre + nums[i], cur);
            pre = cur;
            cur = t;
        }
        return cur;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,5,8,5,1,6};
        int i = new Robber().robber(nums);
        System.out.println(i);
    }
}
