package stack;

import linkedlist.Demo01_DeleteDuplicate;

import java.util.Stack;

//用两个栈模拟队列操作
public class Demo01_ImplQueue<E> {
    /**
     * 使用栈s1和s2模拟队列Q, s1为插入栈, s2为弹出栈, 以实现队列
     * 入队列使用栈s1即可
     * 出队列时, 若s2不为空, 则直接弹出s2栈顶的元素
     * 若s2为空, 则将s1的全部元素弹出, 并且用s2接收, 最后s2栈顶的元素即为队首的元素
     * 同理可以使用两个队列模拟栈, q1为入队列, q2为出队列
     * 可以认为队列q1提供压栈功能, 队列q2提供弹栈功能
     * 出队列时, 若队列q1只有一个元素, 则让该元素出队列并输出即可
     * 若q1不止一个元素, 则q1所以元素出队列, 入q2, 最后一个元素不入q1, 输出该元素, 然后再将q2所有元素入q1
     */
    private Stack<E> s1 = new Stack<E>();
    private Stack<E> s2 = new Stack<E>();
    public synchronized void put(E e){
        s1.push(e);
    }

    /**
     * 当有出队列操作时, 将插入栈的数据全部弹出, 弹出的数据放入弹出站, 此时弹出站的栈顶元素为第一个进队列的元素
     * @return
     */
    public synchronized E pop(){
        if(s2.empty()){
            while (! s1.empty()){
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }
    public synchronized boolean empty(){
        return s1.empty() && s2.empty();
    }

    public static void main(String[] args) {
        Demo01_ImplQueue<Integer> q = new Demo01_ImplQueue<>();
        q.put(1);
        q.put(2);
        q.put(3);
        System.out.println("队列首元素:" + q.pop());
        System.out.println("队列首元素:" + q.pop());
    }

}
