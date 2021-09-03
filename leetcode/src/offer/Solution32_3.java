package offer;

import java.util.*;

/**
 * 请实现一个函数按照之字形顺序打印二叉树，
 *
 * 即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 */
public class Solution32_3 {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        Deque<TreeNode> q = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> t = new ArrayList<>();
            while (size-- > 0) {
                TreeNode node = q.poll();
                t.add(node.val);
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            // 如果为奇数层就翻转当前层的链表t, 从0开始
            if ((res.size() & 1) == 1) Collections.reverse(t);
            res.add(t);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode A = new TreeNode(1);
        A.left = new TreeNode(2);
        A.right = new TreeNode(3);
        A.left.left = new TreeNode(4);
        A.left.right = new TreeNode(5);
        A.right.left = new TreeNode(6);
        A.right.right = new TreeNode(7);
        List<List<Integer>> lists = new Solution32_3().levelOrder(A);
        for (List<Integer>list : lists){
            for (Integer n : list){
                System.out.print(n);
            }
            System.out.println();
        }
    }
}
