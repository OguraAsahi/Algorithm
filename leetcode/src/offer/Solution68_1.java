package offer;

public class Solution68_1 {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root ,TreeNode p, TreeNode q){
        if (root == null){
            return null;
        }
        if (p == q){
            return p;
        }
        while (root != null){
            if (root.val < p.val && root.val < q.val){
                root = root.right;
            } else if (root.val > p.val && root.val > q.val){
                root = root.left;
            } else {
                return root;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode A = new TreeNode(6);
        A.left = new TreeNode(2);
        A.right = new TreeNode(8);
        A.left.left = new TreeNode(0);
        A.left.right = new TreeNode(4);
        A.left.right.left = new TreeNode(3);
        A.left.right.right = new TreeNode(5);
        A.right.left = new TreeNode(7);
        A.right.right = new TreeNode(9);
        A.right.right.right = new TreeNode(10);
        TreeNode node = new Solution68_1().lowestCommonAncestor(A, A.left.left, A.left);
        System.out.println(node.val);
    }
}
