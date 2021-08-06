package offer;

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
