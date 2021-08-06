package offer;

public class Solution10 {
    public int fib(int n) {
        int a = 0, b = 1;
        for (int i = 0; i < n; ++i) {
            int c = (a + b) % 1000000007;
            a = b;
            b = c;
        }
        return a;
    }

    public static void main(String[] args) {
        int n = 10;
        int fib = new Solution10().fib(n);
        System.out.println(fib);
    }
}
