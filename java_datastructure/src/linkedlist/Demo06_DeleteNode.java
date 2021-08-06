package linkedlist;

public class Demo06_DeleteNode {
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
        Demo06_DeleteNode list = new Demo06_DeleteNode();
        list.addNode(1);
        list.addNode(2);
        list.addNode(3);
        list.addNode(4);
        list.addNode(5);
        boolean res = list.deleteNode(list.head.next);
        System.out.println(res);
        list.printList();
    }

    /**
     * 在不知道头指针的情况向删除指定结点n
     * 若待删除结点不为尾结点, 则可以通过交换该结点与其后继结点的值再删除后继节点来实现
     * @param n
     * @return
     */
    public boolean deleteNode(Node n){
        if (n == null || n.next == null){
            // 给定的n结点不能为空且不能为尾结点, 因为无法使前一个结点的next指针指向空
            return false;
        }
        int tmp = n.data;
        n.data = n.next.data;
        n.next.data = tmp;
        n.next = n.next.next;
        return true;
    }


}
