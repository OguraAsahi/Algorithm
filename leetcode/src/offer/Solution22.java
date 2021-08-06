package offer;


public class Solution22 {


    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode getKthFromEnd(ListNode head, int k) {
        if (k < 1){
            return null;
        }
        ListNode slow = head, fast = head;
        // k为1时, slow = fast, 因此返回倒数第一个结点
        for (int i = 0; i < k - 1 && fast != null; i++) {
            fast = fast.next;
        }
        if (fast == null){
            System.out.println("参数k不合法");
            return null;
        }
        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        ListNode node = getKthFromEnd(head, 1);
        System.out.println(node.val);
    }

}
