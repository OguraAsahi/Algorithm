package offer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution32 {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }

    public static int[] levelOrder(TreeNode root){
        if (root == null){
            return new int[]{};
        }
        // 需要一个辅助队列按层记录结点, 和一个链表按层记录值
        Deque<TreeNode> q = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        q.offer(root);
        while (!q.isEmpty()){
            // size记录每层的结点个数
            // 每次循环遍历一层
            int size = q.size();
            while (size-- > 0){
                // 每次循环将队首的结点的val加入list, 同时让队首元素出队列
                // 接下来判断当前节点是否有左右子节点, 若有则加入到队列末尾当中排队
                // 最后让size - 1, 表示从左到右遍历完了一个结点
                TreeNode node = q.poll();
                list.add(node.val);
                if (node.left != null){
                    q.offer(node.left);
                }
                if (node.right != null){
                    q.offer(node.right);
                }
            }
        }
        int i = 0, n = list.size();
        int[] res = new int[n];
        for (Integer integer : list) {
            res[i++] = integer;
        }
        return res;
    }

    public static void main(String[] args){
        TreeNode A = new TreeNode(1);
        A.left = new TreeNode(2);
        A.right = new TreeNode(3);
        A.left.left = new TreeNode(4);
        A.left.right = new TreeNode(5);
        A.right.left = new TreeNode(6);
        A.right.right = new TreeNode(7);
        int[] levelOrder = levelOrder(A);
        for (int i : levelOrder) {
            System.out.println(i);
        }
    }
}
