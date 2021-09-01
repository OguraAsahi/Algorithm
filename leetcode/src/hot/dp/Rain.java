package hot.dp;

/**
 * 接雨水
 *
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */
public class Rain {

    /**
     * 动态规划法。
     *
     * 对于下标 i，水能达到的最大高度等于下标 i 左右两侧的最大高度的最小值，再减去 height[i] 就能得到当前柱子所能存的水量。
     */
    public int trap(int[] height){
        int n;
        if ((n = height.length) < 3){
            return 0;
        }
        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        int[] rightMax = new int[n];
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        int trap = new Rain().trap(height);
        System.out.println(trap);
    }
}
