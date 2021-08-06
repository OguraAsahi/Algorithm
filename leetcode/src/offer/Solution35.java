package offer;

import java.util.HashMap;
import java.util.Map;

public class Solution35 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head){
        if (head == null){
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        Node copyHead = new Node(-1);
        Node cur = copyHead, t = head;
        while (t != null){
            // 创建一个和t一样的结点, 但是没有random指针
            Node node = new Node(t.val);
            // map中put进去的其实就是t, 和一个没有random指针的t, 这样做的原因是为了给后面的新链表附上新的random
            // 也就是map中记录了链表所有的结点和它的复制样本
            map.put(t, node);
            cur.next = node;
            cur = node;
            t = t.next;
        }
        cur = copyHead.next;
        while (head != null){
            // 我们根据复制源结点的random指针找到map中新建的random指针
            cur.random = map.get(head.random);
            cur = cur.next;
            head = head.next;
        }
        return copyHead.next;
    }
}
