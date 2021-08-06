package queue;

import java.util.LinkedList;

/**
 * 采用数组实现队列的方式, 为了实现多线程安全, 增加了对队列操作的同步
 * @param <E>
 */
public class Queue<E> {
    private LinkedList<E> list = new LinkedList<>();
    private int size = 0;
    public synchronized void put(E e){
        list.addLast(e);
        size++;
    }
    public synchronized E pop(){
        size--;
        return list.removeFirst();
    }
    public synchronized boolean isEmpty(){
        return size == 0;
    }
    public synchronized int size(){
        return size;
    }

    public static void main(String[] args) {
        Queue<Integer> q = new Queue<>();
        q.put(1);
        q.put(2);
        q.put(3);
        System.out.println(q.size());
        System.out.println(q.pop());
        System.out.println(q.pop());
    }
}
