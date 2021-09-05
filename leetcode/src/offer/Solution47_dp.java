package offer;

/**
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
 *
 * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
 *
 * 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 */
public class Solution47_dp {
    public int maxValue(int[][] grid){
        int rows = grid.length, cols = grid[0].length;
        int[][] vals = new int[rows][cols];
        vals[0][0] = grid[0][0];
        for (int i = 1; i < rows; i++) {
            vals[i][0] = vals[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < cols; j++) {
            vals[0][j] = vals[0][j - 1] + grid[0][j];
        }
        // 动态规划, 将m * n的大问题分解为2 * 2的小问题
        // 因为一个位置的最大值只与他左边和上边两个位置的最大值有关, 即vals[i][j] = grid[i][j] + Math.max(vals[i - 1][j], vals[i][j - 1]);
        // 这里需要维护一个m * n的二维数组, 每个位置记录到达该位置时能获取的最大值
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                vals[i][j] = grid[i][j] + Math.max(vals[i - 1][j], vals[i][j - 1]);
            }
        }
        return vals[rows - 1][cols - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        int i = new Solution47_dp().maxValue(grid);
        System.out.println(i);
    }
}
