package sort;

import java.util.Arrays;

/**
 * Author：yfan.chen
 * Date：2021-08-31 10:02 上午
 **/
public class Simple_MergeSort {

    public void mergeSort(int[] nums, int left, int right){
        if (left >= right){
            return;
        }
        int mid = (left + right) >>> 1;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        int i = left, j = mid + 1, k = 0;
        int[] temp = new int[right - left + 1];
        while (i <= mid && j <= right){
            if (nums[i] <= nums[j]){
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        while (i <= mid){
            temp[k++] = nums[i++];
        }
        while (j <= right){
            temp[k++] = nums[j++];
        }
        System.arraycopy(temp, 0, nums, left, right - left + 1);
    }

    public static void main(String[] args) {
        int[] nums = {9,8,7,6,5,4,3,2,1};
        new Simple_MergeSort().mergeSort(nums, 0, nums.length - 1);
        Arrays.stream(nums).forEach(System.out::print);
    }

}
