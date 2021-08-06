package offer;

/**
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，
 * 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */

//从右上角开始判断, 坐标为(0, n - 1)
//若target小于该数, 则该列就不可能了, 列号-1
//若target大于该数, 则改行左边就不可能了, 行号+1, 如此循环
public class Solution04 {

    public boolean findNumberIn2DArray(int[][] matrix, int target){
        int m, n;
        if (matrix == null || (m = matrix.length) == 0 || matrix[0] == null || (n = matrix[0].length) == 0){
            return false;
        }
        int i = 0, j = n - 1;
        while (i < m && j >= 0){
            if (matrix[i][j] == target){
                return true;
            } else if (matrix[i][j] > target){
                --j;
            }else {
                ++i;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3}, {3,4,5}};
        boolean result = new Solution04().findNumberIn2DArray(matrix, 0);
        System.out.println(result);
    }
}
