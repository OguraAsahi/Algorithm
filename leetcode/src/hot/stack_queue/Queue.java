package hot.stack_queue;

import java.util.Stack;

public class Queue<E> {
    private Stack<E> s1 = new Stack<E>();
    private Stack<E> s2 = new Stack<E>();
    public synchronized void put(E e){
        s1.push(e);
    }

    public synchronized E pull(){
        if (s2.empty()){
            while (!s1.empty()){
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }

    public synchronized boolean empty(){
        return s1.empty() && s2.empty();
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<Integer>();
        queue.put(1);
        queue.put(2);
        queue.put(3);
        System.out.println(queue.pull());
    }
}
