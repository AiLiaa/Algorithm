package DynamicProgramming;

import java.util.Arrays;

/**
 * 零钱兑换
 *
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1。
 * 你可以认为每种硬币的数量是无限的。
 *
 * 示例 1：
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 *
 * 示例 2：
 * 输入：coins = [2], amount = 3
 * 输出：-1
 *
 * 提示：
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 2^31 - 1
 * 0 <= amount <= 10^4
 */
public class CoinChange {

    public int solution(int[] coins, int amount) {
        if (amount == 0) return 0;

        int[] dp = new int[amount + 1];
        //初始化
        for (int i = 0; i < coins.length; i++) {
            if (amount >= coins[i]) dp[coins[i]] = 1;
        }

        for (int j = 0; j <= amount; j++) {
            for (int i = 0; i < coins.length; i++) {
                //dp[j - coins[i]] != 0即为存在该硬币组合
                if (j - coins[i] >= 0 && dp[j - coins[i]] != 0){
                    if (dp[j] == 0){
                        dp[j] = dp[j - coins[i]] + 1;
                    }else {
                        dp[j] = Math.min(dp[j],dp[j - coins[i]] + 1);
                    }
                }
            }
        }
        return dp[amount] == 0 ? -1 : dp[amount];
    }

    //初始化不同
    public int solution2(int[] coins, int amount) {

        int[] dp = new int[amount  +1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                if (dp[j - coins[i]] != Integer.MAX_VALUE){
                    dp[j] = Math.min(dp[j],dp[j - coins[i]] + 1);
                }
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
