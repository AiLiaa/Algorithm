package Greedy;

import java.util.Arrays;

/**
 * 买卖股票的最佳时机 II
 *
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 示例 1:
 * 输入: [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4。
 * 随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 *
 * 最终利润是可以分解
 * 假如第0天买入，第3天卖出，那么利润为：prices[3] - prices[0]。
 * 相当于(prices[3] - prices[2]) + (prices[2] - prices[1]) + (prices[1] - prices[0])。
 * 根据prices可以得到每天的利润序列：(prices[i] - prices[i - 1]).....(prices[1] - prices[0])。
 * 收集正利润的区间，就是股票买卖的区间，而我们只需要关注最终利润，不需要记录区间。
 *
 */
public class BestTimeBuySellStocksII {

    public int solution(int[] prices) {
        // 每天的利润序列
        int[] profit = new int[prices.length];

        for (int i = 1; i < prices.length; i++) {
            profit[i] = prices[i] - prices[i - 1];
        }

        int res = 0;
        for (int i = 1; i < profit.length; i++) {
            if (profit[i] > 0) res += profit[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,4};
        BestTimeBuySellStocksII b = new BestTimeBuySellStocksII();
        int r = b.solution(prices);
        System.out.println(r);
    }
}
