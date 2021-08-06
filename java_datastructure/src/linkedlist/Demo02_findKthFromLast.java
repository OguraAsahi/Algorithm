package linkedlist;

import java.util.Hashtable;

public class Demo02_findKthFromLast {

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        Demo02_findKthFromLast test = new Demo02_findKthFromLast();
        list.addNode(2);
        list.addNode(23);
        list.addNode(234);
        list.addNode(2345);
        list.addNode(23);
        list.addNode(23);
        list.addNode(234);
        MyLinkedList.Node result = test.Find(list.head, 1);
        System.out.println(result.data);
    }

    public MyLinkedList.Node Find(MyLinkedList.Node head, int k){
        if (k < 1){
            return null;
        }
        MyLinkedList.Node p1 = head;
        MyLinkedList.Node p2 = head;
        for (int i = 0; i < k - 1 && p1 != null; i++) {
            p1 = p1.next;
        }
        if (p1 == null){
            System.out.println("参数k不合法");
            return null;
        }
        while (p1.next != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }
}
