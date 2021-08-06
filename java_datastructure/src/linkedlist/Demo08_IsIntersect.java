package linkedlist;

public class Demo08_IsIntersect {
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
        Demo08_IsIntersect list = new Demo08_IsIntersect();
        list.addNode(1);
        list.addNode(2);
        list.addNode(3);
        list.addNode(4);
        list.addNode(5);
    }

    /**
     * 判断两个链表是否相交, 时间复杂度为O(len1+len2)
     * @param h1
     * @param h2
     * @return
     */
    public boolean isIntersect(Node h1, Node h2){
        if (h1 == null || h2 == null){
            return false;
        }
        Node tail1 = h1;
        while (tail1.next != null){
            tail1 = tail1.next;
        }
        Node tail2 = h1;
        while (tail2.next != null){
            tail2 = tail2.next;
        }
        return (tail1 == tail2);
    }

    /**
     * 如果两个链表相交, 如何找到他们相交的第一个结点, 时间复杂度O(len1 + len2)
     * @param h1
     * @param h2
     * @return
     */
    public static Node getFirstMeetNode(Node h1, Node h2){
        if (h1 == null || h2 == null){
            return null;
        }
        Node tail1 = h1;
        int len1 = 0;
        while (tail1.next != null){
            tail1 = tail1.next;
            len1++;
        }
        Node tail2 = h1;
        int len2 = 0;
        while (tail2.next != null){
            tail2 = tail2.next;
            len2++;
        }
        // 两链表不相交
        if (tail1 != tail2){
            return null;
        }
        Node t1 = h1;
        Node t2 = h2;
        if (len1 > len2){
            int d = len1 - len2;
            while (d != 0){
                t1 = t1.next;
                d--;
            }
        } else {
            int d = len2 - len1;
            while (d != 0){
                t2 = t2.next;
                d--;
            }
        }
        while (t1 != t2){
            t1 = t1.next;
            t2 = t2.next;
        }
        return t1;
    }

}
