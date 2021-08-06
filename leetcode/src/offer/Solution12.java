package offer;

public class Solution12 {
    private boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        visited = new boolean[m][n];
        char[] words = word.toCharArray();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean res = dfs(board, i, j, words, 0);
                if (res){
                    return true;
                }
            }
        }
        return false;

    }

    private boolean dfs(char[][] board, int i, int j, char[] chars, int cur) {
        if (cur == chars.length){
            // 切记返回true的条件只有一个, 那就是找到了完整路径
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length){
            return false;
        }
        if (visited[i][j] || board[i][j] != chars[cur]){
            return false;
        }
        visited[i][j] = true;
        int next = cur + 1;
        boolean res = dfs(board, i + 1, j, chars, next) || dfs(board, i - 1, j, chars, next)
                || dfs(board, i, j + 1, chars, next) || dfs(board, i, j - 1, chars, next);
        // visited只是作为一个标记量, 让dfs过程中不能回到已经访问过的位置,
        // 若dfs结束, res接收到任何一个true都表示找到路径, 此时改变visited为false对后续已经没有影响
        // 而res接收到false时将visited赋值为false则是必要的
        visited[i][j] = false;
        return res;
    }


    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String str = "ABCCEESE";
        boolean res = new Solution12().exist(board, str);
        System.out.println(res);
    }
}
