package offer;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution30 {
    // Java堆栈Stack类已经过时，Java官方推荐使用Deque替代Stack使用。Deque堆栈操作方法：push()、pop()、peek()。
    // s1记录完整的栈
    // s2记录栈的最小值, 每当push一个值时, 若该值不为最小, 则往s2里push一个原先最小的值, 保证s2中最小值的开始位置和s1中的最小值位置一致
    private Deque<Integer> s1;
    private Deque<Integer> s2;

    // 初始化方法
    public Solution30(){
        s1 = new ArrayDeque<>();
        s2 = new ArrayDeque<>();
    }

    public void push(int x){
        s1.push(x);
        s2.push(s2.isEmpty() || s2.peek() >= x ? x : s2.peek());
    }

    public void pop(){
        s1.pop();
        s2.pop();
    }

    public int top(){
        return s1.peek();
    }

    public int min(){
        return s2.peek();
    }

    public static void main(String[] args){
        Solution30 minStack = new Solution30();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.push(-3);
        int min = minStack.min();
        System.out.println(min);
        minStack.pop();
        minStack.pop();
        int top = minStack.top();
        min = minStack.min();
        System.out.println(min);
    }

}
