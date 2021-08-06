package sort;

public class InsertSort {
    private static void insertSort(int[] nums) {
        for (int i = 1, j, n = nums.length; i < n; ++i) {
            int num = nums[i];
            // 从右往左找个合适的位置插入
            for (j = i - 1; j >=0 && nums[j] > num; --j) {
                // nums[i]是我们要插入的值, 从i - 1开始向左遍历, 如果左边的值比要插入的大, 则将其后移一位, 直到找到比nums[i]小的值
                nums[j + 1] = nums[j];
            }
            nums[j + 1] = num;
        }
    }
}
