package offer;

public class Solution14 {
    public int cuttingRope(int n) {
        if (n < 4) return n - 1;
        int res = 1;
        while (n > 4) {
            res *= 3;
            n -= 3;
        }
        if (n == 4) return res << 2;
        return res * n;
    }

    public static void main(String[] args) {
        int result = new Solution14().cuttingRope(10);
        System.out.println(result);
    }
}
