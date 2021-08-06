package linkedlist;

public class Demo07_IsLoop {
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
        Demo07_IsLoop list = new Demo07_IsLoop();
        list.addNode(1);
        list.addNode(2);
        list.addNode(3);
        list.addNode(4);
        list.addNode(5);
        list.head.next.next.next.next.next = list.head.next.next;
        boolean flag = list.IsLoop(list.head);
        System.out.println(flag);
        Node res = list.FindLoopPort(list.head);
        System.out.println(res.data);
    }

    /**
     * 判断链表是否有环, 利用快慢指针, 若两指针相遇则说明有环
     * @param head
     * @return
     */
    public boolean IsLoop(Node head){
        Node fast = head;
        Node slow = head;
        if (fast == null){
            return false;
        }
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                return true;
            }
        }
        return !(fast == null || fast.next == null);
    }

    /**
     * 找到环的入口点,当fast和slow相遇时, slow还没有遍历完链表, 而fast指针已经在环内循环了n圈
     * 假设slow指针走了s步, 则fast指针走了2s步, 且2s = s + nr, r为环长
     * 设链表长为L, 入口点和相遇点距离x, 起点到入口点距离a, 则有:
     * 2s = a + x + nr, 即a + x = nr
     * a + x = (n - 1)r + r = (n - 1)r + (L - a)从起点到相遇的距离等于n圈循环
     * 则a = (n - 1)r + (L - a - x)
     * L - a - x为相遇点到环入口点的距离(指向性的, 经过了一次跳转)
     * 从链表头到相遇点的距离为(n - 1)圈内循环 + 相遇点到环入口点的距离
     * 于是在链表头与相遇点分别设一个指针, 每次走一步, 两个指针必定相遇
     * 且相遇第一点为环入口点(用到了a = (n - 1)r + (L - a - x)
     * @param head
     * @return
     */
    public Node FindLoopPort(Node head){
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                break;
            }
        }
        if (fast == null || fast.next == null){
            return null;
        }
        slow = head;
        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
