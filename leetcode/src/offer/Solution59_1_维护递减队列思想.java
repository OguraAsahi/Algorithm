package offer;

import java.util.LinkedList;

/**
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 */
public class Solution59_1_维护递减队列思想 {
    public int[] maxSlidingWindow(int[] nums, int k){
        int index = 0, n = nums.length;
        if (k == 0 || n == 0){
            return new int[]{};
        }
        int[] res = new int[n - k + 1];
        LinkedList<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            // 如果最后一位比新来的数小, 则把最后一位弹出, 因为它已经不可能是滑动窗口中最大的那个
            // 也就是说维护q中的数从前往后递减, 这会产生一个问题: 一个很大的老数据会占着First
            // 所以在后面要维护队列中至多只有最新来的三个数
            while (!q.isEmpty() && nums[q.peekLast()] <= nums[i]){
                Integer integer = q.pollLast();
            }
            // 将新来的加入到最后一位
            q.addLast(i);
            // 如果最早来的为i - k, 说明滑动窗口中已经有相邻的3个数了, 超过容量, 必须弹出最开始那个
            // 维护q中最多只有三个数
            if (q.peekFirst() == i - k){
                q.pollFirst();
            }
            // 对第三个数及之后的所有滑动窗口记录最大值
            if (i >= k - 1){
                res[index++] = nums[q.peekFirst()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new Solution59_1_维护递减队列思想().maxSlidingWindow(new int[]{5, 3, 2, 4, 9}, 3);
        for(int num : nums){
            System.out.println(num);
        }
    }
}
