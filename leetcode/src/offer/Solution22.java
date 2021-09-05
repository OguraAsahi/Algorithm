package offer;

/**
 * 输入一个链表，输出该链表中倒数第 k 个节点。
 *
 * 为了符合大多数人的习惯，本题从 1 开始计数，即链表的尾节点是倒数第 1 个节点。
 *
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
 */
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
