package offer;

/**
 * 地上有一个 m 行 n 列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 *
 * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于 k 的格子。
 *
 * 例如，当 k 为 18 时，机器人能够进入方格 [35, 37] ，因为 3+5+3+7=18。但它不能进入方格 [35, 38]，因为 3+5+3+8=19。请问该机器人能够到达多少个格子？
 */
public class Solution13 {

    private int m;
    private int n;
    private boolean[][] visited;
    private int cnt;

    public int movingCount(int m, int n, int k) {
        visited = new boolean[m][n];
        this.m = m;
        this.n = n;
        cnt = 0;
        dfs(0, 0, k);
        return cnt;
    }

    private void dfs(int i, int j, int k) {
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || cal(i, j) > k)
            return;
        ++cnt;
        // 不同于寻找路径, 我们在赋值visited为true后不需要再变回来, 因为统计的是能到达几个格子
        visited[i][j] = true;
        dfs(i + 1, j, k);
        dfs(i - 1, j, k);
        dfs(i, j + 1, k);
        dfs(i, j - 1, k);
    }

    private int cal(int i, int j) {
        int res = 0;
        while (i != 0) {
            res += (i % 10);
            i /= 10;
        }
        while (j != 0) {
            res += (j % 10);
            j /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        int m = 20, n = 30, k = 10;
        int count = new Solution13().movingCount(m, n, k);
        System.out.println(count);
    }

}
