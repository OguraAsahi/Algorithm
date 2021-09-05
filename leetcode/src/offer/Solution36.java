package offer;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。
 *
 * 要求不能创建任何新的节点，只能调整树中节点指针的指向。
 */
public class Solution36 {
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node() {}
        public Node(int _val) {
            val = _val;
        }
        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };

    Node head;
    Node pre;

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        dfs(root);
        // 经过dfs后, head变为了最小(左)的那个节点, pre变为了最大(右)的那个节点, 此时将二者连接即可
        head.left = pre;
        pre.right = head;
        return head;
    }

    private void dfs(Node cur) {
        if (cur == null) return;
        // 递归到最小的那个节点, 到了的时候pre还为空, 此时用head记录下来最小的节点
        // 最小的节点记录到head后, 对他之后的节点依次令左子树为前驱, 右子树为后继
        // 此过程类似于中序遍历, 也就是将二叉搜索树按序打印的过程, 我们将打印的步骤变为设置节点前驱和后继
        // 即可实现把树变为一个按序排列的双向链表
        dfs(cur.left);
        if (pre == null) head = cur;
        else pre.right = cur;
        cur.left = pre;
        pre = cur;
        dfs(cur.right);
    }

    public static void main(String[] args) {
        Node A = new Node(5);
        A.left = new Node(3);
        A.left.left = new Node(2);
        A.left.left.left = new Node(1);
        A.left.right = new Node(4);
        A.right = new Node(8);
        A.right.left = new Node(6);
        A.right.left.right = new Node(7);
        A.right.right = new Node(10);
        A.right.right.left = new Node(9);
        Node head = new Solution36().treeToDoublyList(A);
        System.out.println(head.left.val);
        System.out.println(head.left.left.val);
        System.out.println(head.val);
        System.out.println(head.right.val);
        System.out.println(head.right.right.val);
        System.out.println(head.right.right.right.val);
    }
}
