package stack;

// 如何用O(1)的时间复杂度求栈中最小的元素
// 采用空间换时间的方法, 使用两个栈结构, 一个存储数据, 一个存储栈的最小元素
public class MyStack1<E> {
    Stack<Integer> elem;
    Stack<Integer> min;
    public MyStack1(){
        elem = new Stack<Integer>();
        min = new Stack<Integer>();
    }
    public void push(int data){
        elem.push(data);
        if (min.isEmpty()){
            min.push(data);
        } else {
            if (data <= min.peek()){
                min.push(data);
            }
        }
    }
    public int pop(){
        int topData = elem.peek();
        elem.pop();
        if (topData == this.min()){
            min.pop();
        }
        return topData;
    }
    public int min(){
        if (min.isEmpty()){
            return Integer.MAX_VALUE;
        } else{
            return min.peek();
        }
    }

    public static void main(String[] args) {
        MyStack1<Integer> s = new MyStack1<>();
        s.push(3);
        s.push(-1);
        s.push(2);
        s.push(2);
        s.push(1);
        s.push(1);
        s.push(0);
        s.push(-1);
        System.out.println(s.min());
        s.pop();
        System.out.println(s.min());
        s.pop();
        System.out.println(s.min());
    }
}

