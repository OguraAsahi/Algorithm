package hot.dfs;

public class MatrixPath {

    boolean[][] visited;
    public boolean exist(char[][] matrix, String words){
        int m = matrix.length, n = matrix[0].length;
        visited = new boolean[m][n];
        char[] chars = words.toCharArray();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 表示从任意一个结点出发
                boolean res = dfs(matrix, i, j, chars, 0);
                if (res){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] matrix, int i, int j, char[] chars, int cur){
        if (cur == chars.length){
            return true;
        }
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length){
            return false;
        }

        if (visited[i][j] || matrix[i][j] != chars[cur]){
            return false;
        }
        visited[i][j] = true;
        int next = cur + 1;
        boolean res = dfs(matrix, i + 1, j, chars, next) || dfs(matrix, i, j + 1, chars, next)
                || dfs(matrix, i - 1, j, chars, next) || dfs(matrix, i, j - 1, chars, next);
        visited[i][j] = false;
        return res;
    }
}
