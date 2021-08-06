package offer;

public class Solution14_2 {
    public int cuttingRope(int n) {
        if (n < 4) {
            return n - 1;
        }
        int s1 = n / 3;
        int m = n % 3;
        // 说明最后一段长为4, 不能再切
        if (m == 1) {
            s1 -= 1;
            m = 4;
        }
        long res = 1;
        while (s1-- > 0) {
            res *= 3;
            res %= 1000000007;
        }
        return (int) ((res * (m == 0 ? 1 : m)) % 1000000007);
    }

    public static void main(String[] args) {
        int result = new Solution14_2().cuttingRope(10);
        System.out.println(result);
    }
}
