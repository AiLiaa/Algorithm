package DynamicProgramming;

/**
 * 组合总和 Ⅳ
 *
 * 给定一个由正整数组成且不存在重复数字的数组，找出和为给定目标正整数的组合的个数。
 *
 * 示例:
 * nums = [1, 2, 3]
 * target = 4
 *
 * 所有可能的组合为： (1, 1, 1, 1) (1, 1, 2) (1, 2, 1) (1, 3) (2, 1, 1) (2, 2) (3, 1)
 * 请注意，顺序不同的序列被视作不同的组合。
 * 因此输出为 7。
 *
 * 如果求组合数就是外层for循环遍历物品，内层for遍历背包。
 * 如果求排列数就是外层for遍历背包，内层for循环遍历物品。
 *
 */
public class CombinationSum4 {
    public int solution(int[] nums, int target) {

        int[] dp = new int[target + 1];
        dp[0] = 1;

        // 先遍历背包容量
        for (int j = 0; j <= target; j++) {
            for (int i = 0; i < nums.length; i++) {
                if (j - nums[i] >= 0) dp[j] += dp[j - nums[i]];
            }
        }

        return dp[target];
    }
}
