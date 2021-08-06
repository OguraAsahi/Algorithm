package offer;

public class Solution21 {
    public int[] exchange(int[] nums) {
        int p = 0, q = nums.length - 1;
        while (p < q) {
            // 类似快排的思想, 从首尾出发, 首指针遇到偶数则停下来让尾指针前进, 尾指针遇到奇数时就交换两个指针
            if ((nums[p] & 1) == 1) {
                ++p;
                continue;
            }
            if ((nums[q] & 1) == 0) {
                --q;
                continue;
            }
            swap(nums, p, q);
        }
        return nums;
    }

    private void swap(int[] nums, int p, int q) {
        int t = nums[p];
        nums[p] = nums[q];
        nums[q] = t;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int[] exchange = new Solution21().exchange(nums);
        for (int i : exchange) {
            System.out.println(i);
        }
    }
}
