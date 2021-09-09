package scanner.xiaomi.before;

import java.util.Scanner;

/**
 * 第一题：判断密码是否符合要求：
 * 给一系列密码：每个密码用空格分隔
 *（1）同时具有大写、小写、符号、数字输出0；
 *（2）长度不在8-120之间，输出1；
 *（3）类型不符合输出2
 */
public class Main4 {


    public static boolean exist(char[][] board, String word)
    {
        if(board == null || board.length ==0 || board[0].length == 0 || word.equals(""))
        {
            return false;
        }
        int m = board.length;
        int n = board[0].length;

        boolean visited[][] = new boolean[m][n];
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(board[i][j] == word.charAt(0) && dfs(i, j, 0, word, visited, board))
                {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean dfs(int i, int j, int idx, String word, boolean visited[][], char board[][]) {
        if (idx == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(idx) || visited[i][j]) {
            return false;
        }
        visited[i][j] = true;
        if (dfs(i + 1, j, idx + 1, word, visited, board) || dfs(i, j + 1, idx + 1, word, visited, board)
                || dfs(i - 1, j, idx + 1, word, visited, board) || dfs(i, j - 1, idx + 1, word, visited, board)) {
            return true;
        }
        visited[i][j] = false;

        return false;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
    }
}
