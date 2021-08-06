package linkedlist;

import java.util.Hashtable;

public class Demo01_DeleteDuplicate {

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        Demo01_DeleteDuplicate test = new Demo01_DeleteDuplicate();
        list.addNode(2);
        list.addNode(23);
        list.addNode(234);
        list.addNode(2345);
        list.addNode(23);
        list.addNode(23);
        list.addNode(234);
        test.deleteDuplicate(list.head);
        list.printList();
    }

    /**删除重复元素, 时间复杂度较低, 需要额外存储空间
     * @param head
     */
    public void deleteDuplicate(MyLinkedList.Node head){
        Hashtable<Integer, Integer> table = new Hashtable<>();
        MyLinkedList.Node tmp = head;
        MyLinkedList.Node pre = null;
        while (tmp != null){
            if (table.containsKey(tmp.data)){
                pre.next = tmp.next;    //此处相当于node.next = node.next.next
            } else {
                table.put(tmp.data, 1);
                pre = tmp;  //以地址空间来操作
            }
            tmp = tmp.next;
        }
    }

    /**删除重复元素,对链表进行双重循环遍历, 不需要额外存储空间, 但时间复杂度较高
     * @param head
     */
    public void deleteDuplicate2(MyLinkedList.Node head){
        MyLinkedList.Node p = head;
        while (p != null){
            MyLinkedList.Node q = p;
            while (q.next != null){
                if (q.data == q.next.data){
                    q.next = q.next.next;
                } else {
                    q = q.next;
                }
                p = p.next;
            }
        }
    }
}
