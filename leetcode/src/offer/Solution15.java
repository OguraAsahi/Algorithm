package offer;

public class Solution15 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            n &= (n - 1);
            ++res;
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 2147483647;
        int res = new Solution15().hammingWeight(n);
        System.out.println(res);
    }
}
