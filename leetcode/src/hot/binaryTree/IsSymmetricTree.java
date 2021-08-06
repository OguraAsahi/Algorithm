package hot.binaryTree;

public class IsSymmetricTree {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }

    public boolean isSymmetricTree(TreeNode root){
        if (root == null){
            return true;
        }
        return isSymmetricTree(root.left, root.right);
    }

    public boolean isSymmetricTree(TreeNode left, TreeNode right){
        if (left == null && right == null){
            return true;
        }
        if (left == null || right == null || left.val == right.val){
            return false;
        }
        return isSymmetricTree(left.left, right.right) && isSymmetricTree(left.right, right.left);
    }
}
