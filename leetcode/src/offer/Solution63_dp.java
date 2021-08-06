package offer;

public class Solution63_dp {
    public int maxProfit(int[] prices){
        int len = prices.length;
        if (len == 0){
            return 0;
        }
        int min = prices[0];
        int res = 0;
        for (int i = 1; i < len; i++) {
            res = Math.max(res, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int i = new Solution63_dp().maxProfit(new int[]{5, 4, 1, 6, 7, 8});
        System.out.println(i);
    }
}
