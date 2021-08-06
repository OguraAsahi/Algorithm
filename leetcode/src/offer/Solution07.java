package offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 */

/**
 * 由前序遍历和中序遍历的特性可知, 前序遍历的结点是各子树的根节点, 找到中序遍历中根节点的位置就能判断其左子树和右子树的所有节点
 * 如此递归下去即可, 当p1超过p2或者i1超过i2时return null
 * 我们需要一个哈希表来记录各子树根节点在中序遍历中的位置, 以便区分左右子树的界限
 */
public class Solution07 {
    class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
        }
    }

    private Map<Integer, Integer> indexes = new HashMap<>();

    public Node buildTree(int[] preOrder, int[] inOrder){
        if (preOrder == null || inOrder == null){
            return null;
        }
        int length = preOrder.length;
        for (int i = 0; i < length; ++i) {
            indexes.put(inOrder[i], i);
        }

        return build(preOrder, inOrder, 0, length - 1, 0, length - 1);
    }

    /**
     *
     * @param preOrder: 先序遍历的数组
     * @param inOrder: 中序遍历的数组
     * @param p1: 先序数组的起始位置
     * @param p2: 先序数组的终止位置
     * @param i1: 中序数组的起始位置
     * @param i2: 中序数组的终止位置
     * @return
     *
     * 求左子树:
     * p1 = p1 + 1
     * p2 = p1 + pos - i1: 即起始位置 + 左子树的所有节点个数
     * i1 = i1
     * i2 = pos - 1: 即根节点位置 - 1
     * 求右子树:
     * p1 = pos - i1 + p1 + 1: 即起始位置 + 左子树的结点个数 + 1,
     * p2 = p2
     * i1 = pos + 1: 即根节点位置 + 1
     * i2 = i2
     * 判断条件: p1超过p2, i1超过i2
     */
    public Node build(int[] preOrder, int[] inOrder, int p1, int p2, int i1, int i2){
        if (p1 > p2 || i1 > i2)
            return null;
        int rootVal = preOrder[p1];
        int pos = indexes.get(rootVal);
        Node node = new Node(rootVal);
        // 记得要判断到底有没有左右子树
        node.left = pos == i1 ? null : build(preOrder, inOrder, p1 + 1, pos - i1 + p1, i1, pos - 1);
        node.right = pos == i2 ? null : build(preOrder, inOrder, pos - i1 + p1 + 1, p2, pos + 1, i2);
        return node;
    }

    public void printTree(Node root){
        if (root == null)
            return;
        System.out.println(root.data);
        printTree(root.left);
        printTree(root.right);
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 8, 6, 20, 15, 7};
        int[] inorder = {8, 9, 6, 3, 15, 20, 7};
        Solution07 tree = new Solution07();
        Node node = tree.buildTree(preorder, inorder);
        tree.printTree(node);
    }

}
