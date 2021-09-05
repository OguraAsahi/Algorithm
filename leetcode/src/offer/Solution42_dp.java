package offer;

/**
 * 输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 *
 * 要求时间复杂度为 O(n)。
 */
public class Solution42_dp {
    public int maxSubArray(int[] arr){
        int res = arr[0], f = res;
        for (int i = 1; i < arr.length; i++) {
            f = arr[i] + Math.max(f, 0);
            res = Math.max(res, f);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {-3, -2, -1};
        int res = new Solution42_dp().maxSubArray(arr);
        System.out.println(res);
    }
}
