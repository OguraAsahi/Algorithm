package offer;

public class Solution53_1_binary {
    public int search(int[] nums, int target){
        if (nums.length == 0){
            return 0;
        }
        int l = 0, r = nums.length - 1;
        while (l <= r){
            // >>>为无符号右移, 高位补0
            int m = (l + r) >>> 1;
            if (nums[m] == target){
                return count(nums, l, r, m);
            }
            if (nums[m] < target){
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return 0;
    }

    public int count(int[] nums, int l, int r, int m){
        // 此时nums[m]正好为我们找到的target, 我们需要统计它的左右有多少个相同的
        int cnt = 0;
        for (int i = m; i >= l; --i) {
            // 判断m的左边有多少个和num[m]相同的
            if (nums[i] == nums[m]){
                ++cnt;
            } else if (nums[i] < nums[m]){
                break;
            }
        }
        for (int i = m + 1; i <= r; i++) {
            // 判断m的右边有多少个和num[m]相同的
            if (nums[i] == nums[m]){
                ++cnt;
            } else if (nums[i] > nums[m]){
                break;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int cnt = new Solution53_1_binary().search(nums, 7);
        System.out.println(cnt);
    }
}
