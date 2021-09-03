package offer;

/**
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过 1，那么它就是一棵平衡二叉树。
 */
public class Solution55_1_dfs {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }

    public int maxDepth(TreeNode root){
        if (root == null){
            return 0;
        }

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public static void main(String[] args) {
        TreeNode A = new TreeNode(1);
        A.left = new TreeNode(2);
        A.right = new TreeNode(3);
        A.left.left = new TreeNode(4);
        A.left.right = new TreeNode(5);
        A.right.left = new TreeNode(6);
        A.right.right = new TreeNode(7);
        A.right.right.right = new TreeNode(7);
        int depth = new Solution55_1_dfs().maxDepth(A);
        System.out.println(depth);
    }
}
