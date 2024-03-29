package DynamicProgramming;

/**
 * 买卖股票的最佳时机III
 *
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 示例 1:
 * 输入：prices = [3,3,5,0,0,3,1,4]
 * 输出：6
 * 解释：在第 4天（股票价格 = 0）的时候买入，在第6天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
 * 随后，在第 7 天（股票价格 = 1）的时候买入，在第 8天（股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3。
 *
 * 示例 2：
 * 输入：prices = [1,2,3,4,5]
 * 输出：4
 * 解释：在第 1 天（股票价格 = 1）的时候买入，在第 5天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4。
 * 注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。因
 * 为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 *
 * 示例 3：
 * 输入：prices = [7,6,4,3,1]
 * 输出：0
 * 解释：在这个情况下, 没有交易完成, 所以最大利润为0。
 *
 * 示例 4：
 * 输入：prices = [1]
 * 输出：0
 *
 * 提示：
 *
 * 1 <= prices.length <= 10^5
 * 0 <= prices[i] <= 10^5
 *
 */
public class MaxProfit3 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 0) return 0;

        //一天一共就有五个状态，
        //没有操作 （其实我们也可以不设置这个状态）
        //第一次持有股票
        //第一次不持有股票
        //第二次持有股票
        //第二次不持有股票
        //dp[i][j]中 i表示第i天，j为 [0 - 4] 五个状态，dp[i][j]表示第i天状态j所剩最大现金。
        //dp[i][1]，表示的是第i天，买入股票的状态，并不是说一定要第i天买入股票
        int[][] dp = new int[len][5];

        dp[0][1] = -prices[0];
        // 初始化第二次买入的状态是确保 最后结果是最多两次买卖的最大利润
        dp[0][3] = -prices[0];

        for (int i = 1; i < len; i++) {
            //第i天买入股票了，那么dp[i][1] = dp[i-1][0] - prices[i]
            //第i天没有操作，而是沿用前一天买入的状态，即：dp[i][1] = dp[i - 1][1]
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i],dp[i - 1][1]);

            //第i天卖出股票了，那么dp[i][2] = dp[i - 1][1] + prices[i]
            //第i天没有操作，沿用前一天卖出股票的状态，即：dp[i][2] = dp[i - 1][2]
            dp[i][2] = Math.max(dp[i - 1][1] + prices[i],dp[i - 1][2]);

            //第i天买入股票了，那么dp[i][3] = dp[i-1][2] - prices[i]
            //第i天没有操作，沿用前一天卖出股票的状态，即：dp[i][3] = dp[i - 1][3]
            dp[i][3] = Math.max(dp[i - 1][2] - prices[i],dp[i - 1][3]);

            //第i天买入股票了，那么dp[i][4] = dp[i-1][3] + prices[i]
            //第i天没有操作，沿用前一天卖出股票的状态，即：dp[i][4] = dp[i - 1][4]
            dp[i][4] = Math.max(dp[i - 1][3] + prices[i], dp[i - 1][4]);
        }
        return dp[len - 1][4];
    }

    //空间优化
    public int maxProfit1(int[] prices) {
        int[] dp = new int[4];
        // 存储两次交易的状态就行了
        // dp[0]代表第一次交易的买入
        dp[0] = -prices[0];
        // dp[1]代表第一次交易的卖出
        dp[1] = 0;
        // dp[2]代表第二次交易的买入
        dp[2] = -prices[0];
        // dp[3]代表第二次交易的卖出
        dp[3] = 0;
        for(int i = 1; i <= prices.length; i++){
            // 要么保持不变，要么没有就买，有了就卖
            dp[0] = Math.max(dp[0], -prices[i-1]);
            dp[1] = Math.max(dp[1], dp[0]+prices[i-1]);
            // 这已经是第二次交易了，所以得加上前一次交易卖出去的收获
            dp[2] = Math.max(dp[2], dp[1]-prices[i-1]);
            dp[3] = Math.max(dp[3], dp[2]+ prices[i-1]);
        }
        return dp[3];
    }
}
