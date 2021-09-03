package offer;

import java.util.Stack;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 */

public class Solution06 {

    /**
     * 利用堆栈从头到尾将链表的值push进去
     * 然后从依次将堆栈pop出来
     */
    class ListNode{
        int val;
        ListNode next = null;
        public ListNode(int data){
            this.val = data;
        }
    }

    ListNode head = null;

    public int[] reverse(ListNode head){
        if (head == null) return new int[]{};
        // 计算链表长度n
        int n = 0;
        ListNode cur = head;
        while (cur != null) {
            ++n;
            cur = cur.next;
        }
        int[] res = new int[n];
        cur = head;
        while (cur != null) {
            res[--n] = cur.val;
            cur = cur.next;
        }
        return res;
    }


}
