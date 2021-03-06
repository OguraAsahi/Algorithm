package offer;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 输入整数数组 arr，找出其中最小的 k 个数。
 *
 * 例如，输入 4、5、1、6、2、7、3、8 这 8 个数字，则最小的 4 个数字是 1、2、3、4。
 */
public class Solution40 {
    public int[] getSmallestNumbers(int[] arr, int k){
        if (k == 0){
            return new int[]{};
        }
        // 优先队列, 底层是一个小顶堆, 可以通过传入构造器改为大顶堆
        PriorityQueue<Integer> bigRoot = new PriorityQueue<>(k, Collections.reverseOrder());
        for (int e : arr) {
            if (bigRoot.size() < k){
                bigRoot.offer(e);
            } else if (e < bigRoot.peek()){
                bigRoot.poll();
                bigRoot.offer(e);
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = bigRoot.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {3,4,5,6,7};
        int[] smallestNumbers = new Solution40().getSmallestNumbers(arr, 2);
        for (int e : smallestNumbers) {
            System.out.println(e);
        }
    }
}
