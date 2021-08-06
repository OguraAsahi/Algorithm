package offer;


/**
 * 找出数组中重复的数字。
 *
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0 ～ n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
 * 请找出数组中任意一个重复的数字。
 */

//0 ～ n-1 范围内的数，分别还原到对应的位置上，如：数字 2 交换到下标为 2 的位置。
//这种方法不需要额外的数组, 时间复杂度为O(1), 若采用哈希表或者数组记录出现次数, 需要额外空间
//若交换过程中发现重复，则直接返回。
public class Solution03 {

    public int findRepeatNumber(int[] nums){
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            while (nums[i] != i){
                if (nums[i] == nums[nums[i]]){
                    return nums[i];
                }
                swap(nums, i, nums[i]);
            }
        }
        return -1;
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {5,4,3,2,1,0};
        int result = new Solution03().findRepeatNumber(nums);
        System.out.println(result);
    }
}
