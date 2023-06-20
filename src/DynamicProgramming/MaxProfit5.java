package DynamicProgramming;

/**
 * 最佳买卖股票时机含冷冻期
 *
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 *
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 *
 * 示例:
 * 输入: [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 *
 */
public class MaxProfit5 {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        if (length <= 1) return 0;

        //状态一：持有股票状态（今天买入股票，或者是之前就买入了股票然后没有操作，一直持有）
        //不持有股票状态，这里就有两种卖出股票状态
        //状态二：保持卖出股票的状态（两天前就卖出了股票，度过一天冷冻期。或者是前一天就是卖出股票状态，一直没操作）
        //状态三：今天卖出股票
        //状态四：今天为冷冻期状态，但冷冻期状态不可持续，只有一天！
        int[][] dp = new int[length][4];

        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[0][2] = 0;
        dp[0][3] = 0;

        for (int i = 1; i < length; i++) {
            //操作一：前一天就是持有股票状态（状态一），dp[i][0] = dp[i - 1][0]
            //操作二：今天买入了，有两种情况
            //前一天是冷冻期（状态四），dp[i - 1][3] - prices[i]
            //前一天是保持卖出股票的状态（状态二），dp[i - 1][1] - prices[i]
            dp[i][0] = Math.max(dp[i - 1][0],Math.max(dp[i - 1][1],dp[i - 1][3]) - prices[i]);
            //操作一：前一天就是状态二
            //操作二：前一天是冷冻期（状态四）
            dp[i][1] = Math.max(dp[i - 1][1],dp[i - 1][3]);
            //只有一个操作：
            //昨天一定是持有股票状态（状态一），今天卖出
            dp[i][2] = dp[i - 1][0] + prices[i];
            //只有一个操作：
            //昨天卖出了股票（状态三）
            dp[i][3] = dp[i - 1][2];
        }

        return Math.max(dp[length - 1][1],Math.max(dp[length - 1][2],dp[length - 1][3]));

    }
}