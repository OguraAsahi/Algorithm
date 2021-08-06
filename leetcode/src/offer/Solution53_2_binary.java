package offer;

public class Solution53_2_binary {
    public int missingNumber(int[] nums){
        int l = 0, r = nums.length - 1;
        // 需要判断数组只有一位时返回的结果是少0还是少1
        if (r == 0 || nums[0] == 1){
            return nums[0] ^ 1;
        }
        // 当数组的所有数都能对上时, 缺少的是r + 1也就是nums.length
        if (nums[r] == r){
            return r + 1;
        }
        // 以0,1,2,3,4,6,7,8,9  9个元素为例

        // r - 1 > l 设置的很巧妙, 因为当nums[m] == m我们才对l重新设值, 所以l所在的数字永远正确
        // 而跳出循环的条件是r - 1 <= l, 此时必然有r = l + 1 = m,
        // 因为r = m >= l,且num[m] != m也就是说l != m, 所以r此时是缺少的那个数字的后一位
        // 我们甚至可以把条件改为r - 1 != l
        while (r - 1 > l){
            int m = (l + r) >>> 1;
            if (nums[m] == m){
                l = m;
            } else {
                r = m;
            }
        }
        System.out.println(l);
        System.out.println(r);
        // return缺少的那个数字的后一位 - 1;
        return nums[r] - 1;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,3,4,5,6,7,8,9};
        int i = new Solution53_2_binary().missingNumber(nums);
        System.out.println(i);
    }
}
