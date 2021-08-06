package hot.binaryTree;

public class IsSubTree {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }

    public boolean isSubTree(TreeNode A, TreeNode B){
        if (A == null || B == null){
            return false;
        }
        if (A.val != B.val){
            return isSubTree(A.left, B) || isSubTree(A.right, B);
        }
        return sub(A, B) || isSubTree(A.left, B) || isSubTree(A.right, B);
    }

    public boolean sub(TreeNode A, TreeNode B){
        if (B == null){
            return true;
        }
        if (A == null){
            return false;
        }
        return A.val == B.val && sub(A.left, B.left) && sub(A.right, B.right);
    }
}
