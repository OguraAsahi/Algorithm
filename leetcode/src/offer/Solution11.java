package offer;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 *
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 *
 * 例如，数组  [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为 1。
 */
public class Solution11 {
    public int minArray(int[] numbers) {
        int l = 0, r = numbers.length - 1;
        while (l < r) {
            // 为什么用这个取中间值公式, 而不用m = (l + r) >> 1
            // 因为l + r可能会溢出int的最大范围
            // 当l和r为负数时两种公式结果不一样
            int m = l + ((r - l) >> 1);
            if (numbers[m] > numbers[r]) {
                // 此时最小值在m与r之间, 所以把左边界变为m + 1
                l = m + 1;
            } else if (numbers[m] < numbers[r]) {
                // 此时最小值在l与m之间, 把右边界变为m
                r = m;
            } else {
                //  对于1,1,1,0,1这种情况, 无法确定中间值1位于前面的还是后面的递增序列, 所以采取顺序遍历
                --r;
            }
        }
        return numbers[l];
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,0,1};
        int i = new Solution11().minArray(nums);
        System.out.println(i);
    }

}
