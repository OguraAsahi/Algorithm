package linkedlist;

public class Demo04_PrintFromLastToFirst {
    class Node{
        Node next = null;
        int data;
        public Node(int data){
            this.data = data;
        }
    }

    Node head = null;   //链表头的引用

    public void printList(){
        Node tmp = head;
        while (tmp != null){
            System.out.println(tmp.data);
            tmp = tmp.next;
        }
    }

    /**向链表中插入数据
     * @param d :插入数据的内容
     */
    public void addNode(int d){
        Node newNode = new Node(d);
        if (head == null){
            head = newNode;
            return;
        }
        Node tmp = head;
        while(tmp.next != null){
            tmp = tmp.next;
        }
        // add node to end
        tmp.next = newNode;
    }

    public static void main(String[] args) {
        Demo04_PrintFromLastToFirst list = new Demo04_PrintFromLastToFirst();
        list.addNode(1);
        list.addNode(1);
        list.addNode(1);
        list.addNode(2);
        list.addNode(2);
        list.addNode(3);
        list.addNode(3);
        list.addNode(4);
        list.printListReversely(list.head);
    }

    /**使用递归从尾到头输出链表
     * 思想和栈类似, 先遍历一遍链表, 把结点的值压栈, 遍历完后弹栈即可
     * 使用递归不必维护一个额外的栈空间
     * @param head
     */
    public void printListReversely(Node head){
        if (head != null){
            printListReversely(head.next);
            System.out.println(head.data);
        }
    }
}
