package hot.dp.stock_series;

/**
 * Author：yfan.chen
 * Date：2021-09-01 11:23 上午
 **/

/**
 * 给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。
 *
 * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 *
 * 返回获得利润的最大值。
 *
 * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
 */
public class Stock_5 {

    /**
     *动态规划法。
     *
     * 设 f1 表示当天持有股票的最大利润，f2 表示当天没持有股票的最大利润。
     *
     * 初始第 1 天结束时，f1 = -prices[0]，f2 = 0。
     *
     * 从第 2 天开始，当天结束时：
     *
     * 若持有，则可能是前一天持有，今天继续持有；也可能前一天没持有，今天买入，f1 = max(f1, f2 - price)。
     * 若没持有，则可能是前一天持有，今天卖出；也可能是前一天没没有，今天继续没持有，f2 = max(f2, f1 + price - fee)。
     * 最后返回 f2 即可。
     */

    public int maxProfit(int[] prices, int fee){
        int f1 = -prices[0], f2 = 0;
        for (int i = 1; i < prices.length; i++) {
            f1 = Math.max(f1, f2 - prices[i]);
            f2 = Math.max(f2, f1 + prices[i] - fee);
        }
        return f2;
    }

    public static void main(String[] args) {
        int[] prices = {1, 3, 2, 8, 4, 9};
        int maxProfit = new Stock_5().maxProfit(prices, 3);
        System.out.println(maxProfit);
    }
}
