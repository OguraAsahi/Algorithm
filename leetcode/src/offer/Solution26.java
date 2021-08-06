package offer;

public class Solution26 {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        public static boolean isSubStructure(TreeNode A, TreeNode B){
            if (A == null || B == null){
                return  false;
            }

            if (A.val != B.val){
                return isSubStructure(A.left, B) || isSubStructure(A.right, B);
            }
            return sub(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
        }

        public static boolean sub(TreeNode A, TreeNode B){
            // 判断从当前节点A开始, 是否包含B
            if (B == null){
                return true;
            }
            if (A == null){
                return false;
            }
            return A.val == B.val && sub(A.left, B.left) && sub(A.right, B.right);
        }

        public static void main(String[] args){
            TreeNode A = new TreeNode(1);
            A.left = new TreeNode(2);
            A.right = new TreeNode(3);
            A.left.left = new TreeNode(4);
            A.left.right = new TreeNode(5);
            A.right.left = new TreeNode(6);
            A.right.right = new TreeNode(7);

            TreeNode B = new TreeNode(1);
            B.left = new TreeNode(2);
            B.left.left = new TreeNode(4);
            B.right = new TreeNode(3);
            boolean result = isSubStructure(A, B);
            System.out.println(result);
        }
    }
}
