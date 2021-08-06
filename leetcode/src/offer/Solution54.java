package offer;

public class Solution54 {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }

    private int t;
    private int res;

    public int kthLargest(TreeNode root, int k){
        t = k;
        traverse(root);
        return res;
    }

    public void traverse(TreeNode root){
        if (root != null){
            traverse(root.right);
            --t;
            if (t == 0){
                res = root.val;
                return;
            }
            traverse(root.left);
        }
    }

    public static void main(String[] args) {
        TreeNode A = new TreeNode(6);
        A.left = new TreeNode(4);
        A.right = new TreeNode(8);
        A.left.left = new TreeNode(2);
        A.left.right = new TreeNode(5);
        A.right.left = new TreeNode(7);
        A.right.right = new TreeNode(11);

        int i = new Solution54().kthLargest(A, 1);
        System.out.println(i);
    }
}
