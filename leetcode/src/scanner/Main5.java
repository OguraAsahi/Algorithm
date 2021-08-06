package scanner;

import java.util.Scanner;

public class Main5 {

    static class TreeNode{
        char val;
        TreeNode left;
        TreeNode right;
        public TreeNode(char val){
            this.val = val;
        }
    }
    static TreeNode root;

    private static void buildHouses(int month){
        root = new TreeNode('R');
        root.left = new TreeNode('G');
        root.right = new TreeNode('R');
        build(root.left, root.right, month - 1);
        find(root);
    }

    private static void build(TreeNode left, TreeNode right,int month){
        if (month == 1){
            return;
        }
        left.left = new TreeNode('G');
        left.right = new TreeNode('R');
        right.left = new TreeNode('G');
        right.right = new TreeNode('R');
        build(left.left, left.right, month - 1);
        build(right.left, right.right, month - 1);
    }

    private static void find(TreeNode root){
        if (root == null){
            return;
        }
        find(root.left);
        System.out.print(root.val);
        find(root.right);
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String n = in.nextLine();
        if (n.charAt(0) > '9'){
            System.out.println("N");
        }
        int month = Integer.parseInt(n);
        if (month < 0 || month > 12){
            System.out.println("O");
            return;
        }

        if (month == 1){
            System.out.println('R');
            return;
        }
        buildHouses(month);
    }
}
