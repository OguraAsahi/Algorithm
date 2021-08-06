package sort;

import java.util.Arrays;

public class MergeSort {
    private static void sort(int[] nums, int low, int mid, int high, int[] temp){
        // k是记录全局的变量, i,j是记录半区的变量
        int i = low, j = mid + 1, k = low;
        while (k <= high){
            if (i > mid){
                temp[k++] = nums[j++];
            } else if (j > high){
                temp[k++] = nums[i++];
            } else if (nums[i] <= nums[j]){
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        System.arraycopy(temp, low, nums, low, high - low + 1);
    }

    private static void mergeSort(int[] nums, int low, int high, int[] temp){
        if (low >= high){
            return;
        }
        int mid = (low + high) >>> 1;
        mergeSort(nums, low, mid, temp);
        mergeSort(nums, mid + 1, high, temp);
        sort(nums, low, mid, high, temp);
    }

    private static void mergeSort(int[] nums){
        int n = nums.length;
        int[] temp = new int[n];
        mergeSort(nums, 0, n - 1, temp);
    }

    public static void main(String[] args) {
        int[] nums = {5,4,3,2,1,8,7,6,9,10};
        mergeSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
