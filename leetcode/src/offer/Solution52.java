package offer;

public class Solution52 {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
    }

    public ListNode getIntersectionNode(ListNode A, ListNode B){
        if (A == null || B == null){
            return null;
        }
        ListNode p = A, q = B;
        // 不能传A, B因为会改变他们的引用地址
        int lenA = getLen(p);
        int lenB = getLen(q);
        // 因为要保证后面q前进Math.abs(lenA - lenB)个结点, 所以当lenA 大于lenB时, 将两个头结点对调
        if (lenA > lenB){
            ListNode t = A;
            A = B;
            B = t;
        }
        p = A;
        q = B;
        for (int i = 0; i < Math.abs(lenA - lenB); i++) {
            q = q.next;
        }
        while (p != null && q != null){
            if (p == q){
                return p;
            }
            p = p.next;
            q = q.next;
        }
        return null;
    }

    public int getLen(ListNode node){
        int len = 0;
        while (node != null){
            node = node.next;
            ++len;
        }
        return len;
    }

    public static void main(String[] args) {
        ListNode A = new ListNode(1);
        ListNode B = new ListNode(6);
        A.next = new ListNode(2);
        ListNode intersection = new ListNode(3);
        A.next.next = intersection;
        B.next = new ListNode(5);
        B.next.next = new ListNode(4);
        B.next.next.next = intersection;
        intersection.next = new ListNode(7);
        intersection.next.next = new ListNode(8);
        ListNode node = new Solution52().getIntersectionNode(A, B);
        System.out.println(node.val);
    }
}
