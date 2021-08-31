package sort;

import java.util.Arrays;

/**
 * Author：yfan.chen
 * Date：2021-08-31 10:03 上午
 **/
public class Simple_QuickSort {

    public void quickSort(int[] nums, int left, int right){
        if (left >= right){
            return;
        }
        int i = left - 1, j = right + 1;
        int x = nums[left];
        while (i < j){
            while (nums[++i] < x);
            while (nums[--j] > x);
            if (i < j){
                swap(nums, i, j);
            }
        }
        quickSort(nums, left, j);
        quickSort(nums, j + 1, right);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {9,8,7,6,5,4,3,2,1};
        new Simple_QuickSort().quickSort(nums, 0, nums.length - 1);
        Arrays.stream(nums).forEach(System.out::print);
    }
}
