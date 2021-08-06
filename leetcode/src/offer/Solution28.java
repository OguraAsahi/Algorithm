package offer;

public class Solution28 {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }

    public static boolean isSymmetric(TreeNode root){
        if (root == null){
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    public static boolean isSymmetric(TreeNode left, TreeNode right){
        if (left == null && right == null){
            return true;
        }
        if (left == null || right == null || left.val != right.val){
            return false;
        }
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

    public static void main(String[] args){
        TreeNode A = new TreeNode(1);
        A.left = new TreeNode(2);
        A.right = new TreeNode(2);
        A.left.left = new TreeNode(4);
        A.left.right = new TreeNode(5);
        A.right.left = new TreeNode(5);
        A.right.right = new TreeNode(4);
        boolean rs = isSymmetric(A);
        System.out.println(rs);
    }
}
