package offer;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution59_2 {
    private Deque<Integer> p;
    private Deque<Integer> q;

    public Solution59_2(){
        p = new ArrayDeque<>();
        q = new ArrayDeque<>();
    }

    public int max_value(){
        return q.isEmpty() ? -1 : q.peekFirst();
    }

    public void push_back(int value){
        // 维护辅助队列q递减, first位置数最大
        while (!q.isEmpty() && q.peekLast() < value){
            q.pollLast();
        }

        p.addLast(value);
        q.addLast(value);
    }

    public int pop_front(){
        if (p.isEmpty()){
            return -1;
        }

        int res = p.pollFirst();
        if (q.peek() == res){
            q.pollFirst();
        }
        return res;
    }

    public static void main(String[] args) {
        Solution59_2 maxQueue = new Solution59_2();
        int max = maxQueue.max_value();
        System.out.println(max);
        maxQueue.push_back(9);
        maxQueue.push_back(8);
        maxQueue.push_back(7);
        max = maxQueue.max_value();
        System.out.println(max);
        int i = maxQueue.pop_front();
        System.out.println(i);
    }
}
