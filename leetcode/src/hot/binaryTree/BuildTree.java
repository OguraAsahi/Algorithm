package hot.binaryTree;

import java.util.HashMap;


public class BuildTree {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }

    private HashMap<Integer, Integer> indexes = new HashMap<>();

    public TreeNode buildTree(int[] preOrder, int[] inOrder){
        if (preOrder == null || inOrder == null){
            return null;
        }

        int length = preOrder.length;
        for (int i = 0; i < length; i++) {
            indexes.put(inOrder[i], i);
        }
        return build(preOrder, inOrder, 0, length - 1, 0, length - 1);

    }

    public TreeNode build(int[] preOrder, int[] inOrder, int p1, int p2, int i1, int i2){
        if (i1 > i2 || p1 > p2){
            return null;
        }

        int rootVal = preOrder[p1];
        TreeNode node =  new TreeNode(rootVal);
        int pos = indexes.get(rootVal);

        node.left = build(preOrder, inOrder, p1 + 1, p1 + pos - i1, i1, pos - 1);
        node.right = build(preOrder, inOrder, p1 + pos - i1 + 1, p2, pos + 1, i2);
        return node;
    }

    public void printTree(TreeNode root){
        if (root == null)
            return;
        System.out.println(root.val);
        printTree(root.left);
        printTree(root.right);
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 8, 6, 20, 15, 7};
        int[] inorder = {8, 9, 6, 3, 15, 20, 7};
        BuildTree tree = new BuildTree();
        TreeNode treeNode = tree.buildTree(preorder, inorder);
        tree.printTree(treeNode);
    }
}
