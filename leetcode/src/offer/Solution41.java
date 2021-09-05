package offer;

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution41 {
    Queue<Integer> minHeap;
    Queue<Integer> maxHeap;

    /** initialize your data structure here. */
    public Solution41() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
    }

    public void addNum(int num) {
        if (maxHeap.size() == minHeap.size()) {
            maxHeap.offer(num);
            // 放入小根堆(小根堆多1)
            minHeap.offer(maxHeap.poll());
        } else {
            minHeap.offer(num);
            // 放入大根堆(大小堆数量相等)
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        if (((maxHeap.size() + minHeap.size()) & 1) == 0) {
            // 偶数个，取两个堆顶平均值
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
        return minHeap.peek();
    }
}
