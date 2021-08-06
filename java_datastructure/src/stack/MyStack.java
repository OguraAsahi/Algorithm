package stack;

import java.util.Arrays;

public class MyStack<E> {
    private Object[] stack;
    private int size;//数组中存储元素的个数
    public MyStack(){
        stack = new Object[10]; //初始长度为10
    }
    //判断堆栈是否为空
    public boolean isEmpty(){
        return size == 0;
    }
    public E peek(){
        if (isEmpty()){
            return null;
        }
        return (E) stack[size - 1];
    }
    public E pop(){
        E e = peek();
        stack[size - 1] = null;
        size--;
        return e;
    }
    public E push(E item){
        ensureCapacity(size + 1);//检查容量
        stack[size++] = item;
        return item;
    }
    //判断数组容器是否已满, 若已满, 则扩充数组空间
    private void ensureCapacity(int size){
        int len = stack.length;
        if (size > len) { //数组已满
            int newLen = 10;//每次数组扩充的容量
            stack = Arrays.copyOf(stack, newLen);
        }
    }

    public static void main(String[] args) {
        MyStack<Integer> s = new MyStack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println(s.size);
        System.out.println(s.pop());
        System.out.println(s.pop());
    }
}

