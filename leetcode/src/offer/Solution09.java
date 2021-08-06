package offer;

import java.util.ArrayDeque;
import java.util.Deque;

//用两个栈模拟队列操作
public class Solution09 {

    private Deque<Integer> s1;
    private Deque<Integer> s2;
    public Solution09() {
        s1 = new ArrayDeque<>();
        s2 = new ArrayDeque<>();
    }

    public void appendTail(int value) {
        s1.push(value);
        if (s2.isEmpty()) {
            move();
        }
    }

    public int deleteHead() {
        if (s2.isEmpty()) {
            move();
        }
        return s2.isEmpty() ? -1 : s2.pop();
    }

    private void move() {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
    }

    /**
     * 当有出队列操作时, 将插入栈的数据全部弹出, 弹出的数据放入弹出站, 此时弹出站的栈顶元素为第一个进队列的元素
     * @return
     */


}
