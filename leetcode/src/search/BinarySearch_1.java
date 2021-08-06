package search;

/**
 * 查找第一个值等于给定值的元素
 */
public class BinarySearch_1 {
    public static int search(int[] nums, int val) {
        int n = nums.length;
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (nums[mid] < val) {
                low = mid + 1;
            } else if (nums[mid] > val) {
                high = mid - 1;
            } else {
                // 如果nums[mid]是第一个元素，或者nums[mid-1]不等于val
                // 说明nums[mid]就是第一个值为给定值的元素
                if (mid == 0 || nums[mid - 1] != val) {
                    return mid;
                }
                // 如果找到的不是第一个, 则说明mid要左移, 我们再次将high赋值为mid - 1
                high = mid - 1;
            }
        }
        return -1;
    }
}
