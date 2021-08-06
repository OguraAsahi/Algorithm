package hot.math;

public class FrogJumpSteps {
    // 不同于fib的地方在于青蛙从1开始而不是0, 所以return b而不是a
    public int numWays(int n) {
        int a = 0, b = 1;
        for (int i = 0; i < n; ++i) {
            int s = (a + b) % 1000000007;
            a = b;
            b = s;
        }
        return b;
    }
}
