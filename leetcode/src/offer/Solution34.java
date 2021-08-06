package offer;

import java.util.*;

public class Solution34 {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }

    private List<List<Integer>> res;
    private List<Integer> path;
    public List<List<Integer>> pathSum(TreeNode root, int sum){
        if (root == null){
            return Collections.emptyList();
        }
        res = new ArrayList<>();
        path = new ArrayList<>();
        dfs(root, sum);
        return res;
    }

    public void dfs(TreeNode root, int sum){
        if (root == null){
            return;
        }
        path.add(root.val);
        if (root.val == sum && root.left == null && root.right == null){
            // 如果找到了路径和叶节点, 则将当前完整的路径加入到res
            res.add(new ArrayList<>(path));
        }
        // 这里巧妙的改变了sum
        dfs(root.left, sum - root.val);
        dfs(root.right, sum - root.val);
        // 无论是否找到, path都需要remove其中刚记录的节点, 因为如果找到了完整路径并且递归回来, res中已经记录了完整路径, 需要换节点继续扫描
        // 如果没有找到, 则说明该结点不是我们想要的, 于是也要移除换下一个结点扫描
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode A = new TreeNode(1);
        A.left = new TreeNode(2);
        A.right = new TreeNode(3);
        A.left.left = new TreeNode(6);
        A.left.right = new TreeNode(7);
        A.right.left = new TreeNode(4);
        A.right.right = new TreeNode(5);
        List<List<Integer>> lists = new Solution34().pathSum(A, 9);
        for (List<Integer> list : lists) {
            for (Integer n : list) {
                System.out.print(n);
            }
            System.out.println();
        }
    }
}
