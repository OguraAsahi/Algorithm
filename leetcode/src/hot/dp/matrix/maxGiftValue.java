package hot.dp.matrix;

/**
 * Author：yfan.chen
 * Date：2021-09-01 2:23 下午
 **/

/**
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
 *
 * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 */
public class maxGiftValue {
    /**
     * 动态规划法。
     *
     * 我们假设 dp[i][j] 表示走到格子 (i, j) 的礼物最大累计价值，则 dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1]。
     */

    public int maxValue(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        // 给矩阵增加一行一列，最上行和最左列都为0，不用考虑边界值和边界溢出
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1];
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        int[][] grid = {{1,2,3},{4,5,6},{7,8,9}};
        int maxValue = new maxGiftValue().maxValue(grid);
        System.out.println(maxValue);
    }
}
