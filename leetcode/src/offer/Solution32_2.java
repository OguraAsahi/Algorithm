package offer;
import java.util.*;

public class Solution32_2 {

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }

    public static List<List<Integer>> levelOrder(TreeNode root){
        if (root == null){
            return Collections.emptyList();
        }

        Deque<TreeNode> q = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        q.offer(root);
        while (!q.isEmpty()){
            int size = q.size();
            List<Integer> t = new ArrayList<>();
            while (size-- > 0){
                TreeNode node = q.poll();
                t.add(node.val);
                if (node.left != null){
                    q.offer(node.left);
                }
                if (node.right != null){
                    q.offer(node.right);
                }
            }
            res.add(t);
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
        List<List<Integer>> lists = levelOrder(A);
        for (List<Integer> list : lists) {
            for (Integer n : list) {
                System.out.print(n);
            }
            System.out.println();
        }
    }
}
