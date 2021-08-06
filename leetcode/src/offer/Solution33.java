package offer;

public class Solution33 {
    public boolean verifyPostOrder(int[] postorder){
        int n;
        if (postorder == null || (n = postorder.length) == 0){
            return true;
        }
        return verify(postorder, 0, n - 1);
    }

    // 由后序遍历二叉搜索树的特性可知, 最后一个节点是根节点, 且比根节点小的都在左子树, 比根节点大的都是右子树
    // 所以可以采取递归的思想, 将数组划分为左右两部分, 同理可知, 左子树的最后一个节点是他的根节点(pos - 1处)
    // (p2 - 1)则是右子树的根节点, 一定要注意返回false的条件, 即当p的右边出现比根节点小的值
    public boolean verify(int[] postorder, int p1, int p2){
        if (p1 > p2){
            return true;
        }
        int pos = p1;
        // 先找完左子树
        while (pos < p2 && postorder[pos] < postorder[p2]){
            ++pos;
        }
        // p此时划分了左右子树
        int p = pos;
        while (pos < p2){
            if (postorder[pos] < postorder[p2]){
                return false;
            }
            ++pos;
        }
        return verify(postorder, p1, p - 1) && verify(postorder, p, p2 - 1);
    }

    public static void main(String[] args){
        int[] postorder = {1,3,2,6,5};
        boolean b = new Solution33().verifyPostOrder(postorder);
        System.out.println(b);
    }


}
