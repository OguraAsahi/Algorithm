package hot.dp.stock_series;

/**
 * Author：yfan.chen
 * Date：2021-08-31 2:41 下午
 **/

/**
 * 给定一个数组 prices ，其中 prices[i] 是一支给定股票第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 */
public class Stock_2 {
    public int maxProfit_Greedy(int[] prices){
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            res += Math.max(0, prices[i] - prices[i - 1]);
        }
        return res;
    }


    /**
     * 2. 动态规划法
     * 设 f1 表示当天结束后持有股票的最大利润，f2 表示当前结束后没有持有股票的最大利润。
     *
     * 初始第 1 天结束时，f1 = -prices[0]，f2 = 0。
     *
     * 从第 2 天开始，当天结束时：
     *
     * 若持有股票，则可能是前一天持有股票，然后继续持有；也可能是前一天没有持有股票，然后当天买入股票。最大利润 f1 = max(f1, f2 - prices[i])。
     * 若没有持有股票，则可能是前一天没持有股票，今天也没持有股票；或者前一天持有股票，然后今天卖出。最大利润 f2 = max(f2, f1 + prices[i])。
     * 最后返回 f2 即可。
     */
    public int maxProfit_dp(int[] prices){
        int f1 = -prices[0], f2 = 0;
        for (int i = 1; i < prices.length; i++) {
            f1 = Math.max(f1, f2 - prices[i]);
            f2 = Math.max(f2, f1 + prices[i]);
        }
        return f2;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        int[] prices2 = {1,2,3,4,5};
        int[] prices3 = {7,6,4,3,1};
        Stock_2 stock_2 = new Stock_2();
        System.out.println(stock_2.maxProfit_Greedy(prices));
        System.out.println(stock_2.maxProfit_Greedy(prices2));
        System.out.println(stock_2.maxProfit_Greedy(prices3));
        System.out.println(stock_2.maxProfit_dp(prices));
        System.out.println(stock_2.maxProfit_dp(prices2));
        System.out.println(stock_2.maxProfit_dp(prices3));
    }
}
