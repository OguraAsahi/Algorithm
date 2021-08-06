package stack;
    //采用链表的方式实现栈的代码
    class Node<E>{
        Node<E> next = null;
        E data;
        public Node(E data) {
            this.data = data;
        }
    }

    public class Stack<E>{
        Node<E> top = null;
        public boolean isEmpty(){
            return (top == null);
        }
        public void push(E data){
            Node<E> newNode = new Node<E>(data);
            newNode.next = top;
            top = newNode;
        }
        public E pop(){
            if (this.isEmpty()){
                return null;
            }
            E data = top.data;
            top = top.next;
            return data;
        }
        public E peek(){
            if (isEmpty()){
                return null;
            }
            return top.data;
        }

        public static void main(String[] args) {
            Stack<Integer> s = new Stack<>();
            s.push(1);
            s.push(2);
            s.push(3);
            System.out.println(s.pop());
            System.out.println(s.pop());
        }
    }

