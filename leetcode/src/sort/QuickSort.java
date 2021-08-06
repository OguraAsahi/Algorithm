package sort;

import java.util.Arrays;

public class QuickSort {

    private static void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    private static void quickSort(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }
        int p = partition(nums, low, high);
        quickSort(nums, low, p - 1);
        quickSort(nums, p + 1, high);
    }


    private static int partition(int[] nums, int low, int high) {
        int less = low - 1, more = high;
        // low是向前的, more是向后的, 二者相遇说明low前面的数比标准位小, more之后的数比标准大, 最后交换more和high即可
        while (low < more) {
            if (nums[low] < nums[high]) {
                // low和less的进度不一样, 当nums[low] = nums[high]时, 我们会++low, 此时low比less再多前进一位
                // less和low在swap时相差0乃至更多, 更多的部分均为标准值, 也就是该操作是在将前面的标准值不断与nums[low]进行交换
                // 也就是将滞留的标准值推进的过程
                swap(nums, ++less, low++);
            } else if (nums[low] > nums[high]) {
                --more;
               /* while (low < more &&nums[more] > nums[high]){
                    more--;
                }*/
                swap(nums, more, low);
            } else {
                // 当nums[low] = nums[high]时
                ++low;
            }
        }
        swap(nums, more, high);
        // 因为less和low之间相差的总是标准值, 所以我们将最前面的原标准值的位置返回
        return less + 1;
    }

    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        int[] nums = {10, 999, 2, 7, 4, 5, 3, 101, 10, 9, 8, 5, 6, 101, 999};
        quickSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}