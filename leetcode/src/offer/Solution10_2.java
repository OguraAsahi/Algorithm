package offer;

public class Solution10_2 {
    public int numWays(int n) {
        int a = 0, b = 1;
        for (int i = 0; i < n; ++i) {
            int s = (a + b) % 1000000007;
            a = b;
            b = s;
        }
        return b;
    }

    public static void main(String[] args) {
        int i = new Solution10_2().numWays(10);
        System.out.println(i);
    }
}
