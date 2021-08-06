package search;

/**
 * 查找最后一个小于等于给定值的元素
 */
public class BinarySearch_4 {
    public static int search(int[] nums, int val) {
        int n = nums.length;
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (nums[mid] > val) {
                high = mid - 1;
            } else {
                // 如果nums[mid]是最后一个元素，或者nums[mid+1]大于val
                // 说明nums[mid]就是最后一个小于等于给定值的元素
                if (mid == n - 1 || nums[mid + 1] > val) {
                    return mid;
                }
                low = mid + 1;
            }
        }
        return -1;
    }
}
