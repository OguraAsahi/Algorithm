package offer;



public class Solution18 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteNode(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        while (pre.next != null && pre.next.val != val) {
            pre = pre.next;
        }
        // 当刚好删除尾结点时就需要判断以防止空指针异常
        pre.next = pre.next == null ? null : pre.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {

    }

}
