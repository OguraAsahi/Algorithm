package offer;

/**
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B 中的元素 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 */
public class Solution66 {
    public int[] constructArr(int[] a){
        int n = a.length;
        int[] output = new int[n];
        // 先乘左边的所有数
        for (int i = 0, left = 1; i < n; i++) {
            output[i] = left;
            left *= a[i];
        }

        // 再乘右边的所有数
        for (int i = n - 1, right = 1; i >= 0; --i) {
            output[i] *= right;
            right *= a[i];
        }
        return output;
    }
}
