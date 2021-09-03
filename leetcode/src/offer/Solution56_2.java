package offer;

/**
 * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 */
public class Solution56_2 {

    /**
     * 统计所有数字每个位中 1 出现的次数，对于某个位，1 出现的次数一定是 3 的倍数 +1 或 0。
     *
     * 对这个数 %3 得到的结果就是那个出现一次的数字在该位上的值。
     */
    public int singleNumber(int[] nums) {
        int[] bits = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; ++i) {
                bits[i] += (num & 1);
                num >>= 1;
            }
        }
        int res = 0;
        for (int i = 0; i < 32; ++i) {
            if (bits[i] % 3 == 1) {
                res += (1 << i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int i = new Solution56_2().singleNumber(new int[]{1, 2, 3, 4, 1, 2, 3, 4, 1, 2, 3, 4, 5});
        System.out.println(i);
    }
}
