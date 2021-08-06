package linkedlist;

public class Demo05_FindMiddleNode {
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
        Demo05_FindMiddleNode list = new Demo05_FindMiddleNode();
        list.addNode(1);
        list.addNode(1);
        list.addNode(1);
        list.addNode(2);
        list.addNode(2);
        list.addNode(3);
        list.addNode(3);
        list.addNode(4);
        Node res = list.SearchMid(list.head);
        System.out.println(res.data);
        System.out.println(res.next.data);
    }

    /**
     * 查找单链表的中间结点, 如果是双向链表, 可以首尾并行, 两指针相遇时找到中间结点
     * 如果是单向链表, 也可以使用双指针的方式, 具体表现为快慢指针, 一个走1步, 一个走2步
     * 快指针先到链表尾部, 链表长度为奇数时, 慢指针刚好指向中间结点, 为偶数时, 慢指针当前结点和下一个结点都是中间结点
     * @param head
     * @return
     */
    public Node SearchMid(Node head){
        Node p = this.head;
        Node q = this.head;
        // 判断p.next.next是否为空的好处是可以直接判定当链表长为奇数时,
        // 得到的q指针和q的下一个指针均为中间结点, 不判断则找到的q和q的前一个结点为中间结点
        while (p != null && p.next != null && p.next.next != null){
            p = p.next.next;
            q = q.next;
        }
        return q;
    }
}
