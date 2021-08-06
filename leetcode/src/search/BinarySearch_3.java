package search;

/**
 * 查找第一个大于等于给定值的元素
 */
public class BinarySearch_3 {
    public static int search(int[] nums, int val) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (nums[mid] < val) {
                low = mid + 1;
            } else {
                // 如果nums[mid]是第一个元素，或者nums[mid-1]小于val
                // 说明nums[mid]就是第一个大于等于给定值的元素
                if (mid == 0 || nums[mid - 1] < val) {
                    return mid;
                }
                high = mid - 1;
            }
        }
        return -1;
    }
}
