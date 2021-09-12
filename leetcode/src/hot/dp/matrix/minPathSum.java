package hot.dp.matrix;

/**
 * Author：yfan.chen
 * Date：2021-09-01 2:14 下午
 **/

/**
 * 最小路径和
 *
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 */
public class minPathSum {
    /**
     * 动态规划。假设 dp[i][j] 表示到达网格 (i,j) 的最小数字和，先初始化 dp 第一列和第一行的所有值，然后利用递推公式：dp[i][j] = min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j] 求得 dp。
     *
     * 最后返回 dp[m - 1][n - 1] 即可。
     */
    public int minPathSum(int[][] grid){
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {{1,2,3},{4,5,6},{7,8,9}};
        int minPathSum = new minPathSum().minPathSum(grid);
        System.out.println(minPathSum);
    }
}
