package queue;

class Node<E>{
    Node<E> next = null;
    E data;
    public Node(E data){
        this.data = data;
    }
}

public class MyQueue<E> {
    private Node<E> head = null;
    private Node<E> tail = null;
    public boolean isEmpty(){
        return head == tail;
    }
    public void put(E data){
        Node<E> newNode = new Node<E>(data);
        if (head == null && tail == null){
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }
    public E pop(){
        if (this.isEmpty()){
            return null;
        }
        E data = head.data;
        head = head.next;
        return data;
    }
    public int size(){
        Node<E> tmp = head;
        int n = 0;
        while (tmp != null){
            n++;
            tmp = tmp.next;
        }
        return n;
    }

    public static void main(String[] args) {
        MyQueue<Integer> q = new MyQueue<>();
        q.put(1);
        q.put(2);
        q.put(3);
        System.out.println(q.size());
        System.out.println(q.pop());
        System.out.println(q.pop());
    }
}
