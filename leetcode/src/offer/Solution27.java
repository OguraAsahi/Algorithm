package offer;

/**
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 */
public class Solution27 {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }

    public static TreeNode mirrorTree(TreeNode root){
        if (root == null){
            return null;
        }
        TreeNode t = root.left;
        root.left = root.right;
        root.right = t;
        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }

    public static void inorder(TreeNode root){
        if (root == null){
            return;
        }
        System.out.println(root.val);
        inorder(root.left);
        inorder(root.right);
    }

    public static void main(String[] args){
        TreeNode A = new TreeNode(1);
        A.left = new TreeNode(2);
        A.right = new TreeNode(3);
        A.left.left = new TreeNode(4);
        A.left.right = new TreeNode(5);
        A.right.left = new TreeNode(6);
        A.right.right = new TreeNode(7);
        TreeNode mirror = mirrorTree(A);
        inorder(mirror);
    }
}
