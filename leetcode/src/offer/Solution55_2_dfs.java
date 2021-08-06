package offer;

public class Solution55_2_dfs {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }

    public boolean isBalanced(TreeNode root){
        if (root == null){
            return true;
        }

        // 判断当前根节点的左右子树的最大深度差是否超过1即可, 然后递归执行
        return Math.abs(height(root.left) - height(root.right)) <= 1 && (isBalanced(root.left) && isBalanced(root.right));
    }

    public int height(TreeNode root){
        if (root == null){
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
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
        A.right.right.right.right = new TreeNode(7);
        boolean rs = new Solution55_2_dfs().isBalanced(A);
        System.out.println(rs);
    }
}
