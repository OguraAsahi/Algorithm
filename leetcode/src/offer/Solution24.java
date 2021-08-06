package offer;

public class Solution24 {
    public static class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
   }

    public static ListNode reverseList(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        ListNode node = reverseList(head);
        while (node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }
}
