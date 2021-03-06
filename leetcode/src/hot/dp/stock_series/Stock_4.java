package hot.dp.stock_series;

/**
 * Author：yfan.chen
 * Date：2021-09-01 11:23 上午
 **/

/**
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。
 *
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 *
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 */
public class Stock_4 {

    /**
     * 动态规划法。
     *
     * 设 f1 表示当天买入股票后的最大利润，f2 表示当天卖出股票后的最大利润，f3 表示当天空仓后的最大利润。
     *
     * 初始第 1 天结束时，f1 = -prices[0]，f2 = 0，f3 = 0。
     *
     * 从第 2 天开始，当天结束时：
     *
     * 若买入，则说明前一天空仓，然后今天买入，f1 = max(f1, f3 - prices[i])。
     * 若卖出，则只能是之前某一天买入，然后今天卖出，f2 = max(f2, f1 + prices[i])。
     * 若空仓，则只能是之前某一天卖出后，然后今天保持空仓，f3 = max(f3, f2)。
     * 最后返回 f2 即可。
     */

    public int maxProfit(int[] prices){
        int f1 = -prices[0], f2 = 0, f3 = 0;
        for (int i = 1; i < prices.length; i++) {
            int pf1 = f1, pf2 = f2, pf3 = f3;
            // 当天不买则是pf1，买则是昨天的空仓-今天股价
            f1 = Math.max(pf1, pf3 - prices[i]);
            // 当天不卖则是pf2，卖则是昨天的买入+今天股价
            f2 = Math.max(pf2, pf1 + prices[i]);
            // 当天空仓，昨天也空仓则是pf3，昨天卖出则是pf2
            f3 = Math.max(pf3, pf2);
        }
        return f2;
    }

    public static void main(String[] args) {
        int[] prices = {1,2,3,0,2};
        int maxProfit = new Stock_4().maxProfit(prices);
        System.out.println(maxProfit);
    }
}
