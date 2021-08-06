package offer;

public class Solution56_1 {
    public int[] singleNumbers(int[] nums){
        int eor = 0;
        for (int num : nums) {
            eor ^= num;
        }
        // 找出最右边的1, 这个1意味着a,b最后不同的一位
        int diff = eor & (~eor + 1);
        int a = 0;
        for (int num : nums) {
            // 把所有该位为1的数异或一遍, 就能筛选出a或b,因为相同的两个数异或为0, 而只有a,b出现一次
            // 所以最后就是a或b异或0, 还是a或b
            if ((num & diff) == 0) {
                a ^= num;
            }
        }
        // 得到一个数后由于异或具有可逆性, 得出另一个数
        // 实现O(n)的时间复杂度, O(1)的空间复杂度
        int b = a ^ eor;
        return new int[]{a, b};
    }

    public static void main(String[] args) {
        int[] nums = new Solution56_1().singleNumbers(new int[]{1, 2, 3, 4, 4, 3, 2, 1, 5, 6});
        for (int num : nums) {
            System.out.println(num);
        }
    }

}
