package linkedlist;

public class Demo03_ReverseList {
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
        Demo03_ReverseList list = new Demo03_ReverseList();
        list.addNode(1);
        list.addNode(1);
        list.addNode(1);
        list.addNode(2);
        list.addNode(2);
        list.addNode(3);
        list.addNode(3);
        list.addNode(4);
        list.Reverse(list.head);
        list.printList();
    }

    public void Reverse(Node head){
        Node pReversedHead = head;
        Node pNode = head;
        Node pPrev = null;
        while (pNode != null){
            Node pNext = pNode.next;
            if (pNext == null){
                pReversedHead = pNode;
            }
            pNode.next = pPrev;
            pPrev = pNode;
            pNode = pNext;
        }
        this.head = pReversedHead;
    }
}
