package sort;

public class BubbleSort {
    private void bubbleSort(int[] nums){
        boolean hasChange = false;
        for (int i = 0, n = nums.length; i < n - 1 && hasChange; i++) {
            hasChange = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (nums[j + 1] < nums[j]){
                    swap(nums, j, j + 1);
                    hasChange = true;
                }
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
