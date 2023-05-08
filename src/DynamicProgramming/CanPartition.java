package DynamicProgramming;

/**
 * 分割等和子集
 *
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * 注意: 每个数组中的元素不会超过 100 数组的大小不会超过 200
 *
 * 示例 1:
 * 输入: [1, 5, 11, 5]
 * 输出: true
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 *
 * 示例 2:
 * 输入: [1, 2, 3, 5]
 * 输出: false
 * 解释: 数组不能分割成两个元素和相等的子集.
 *
 * 提示：
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 100
 *
 * 只有确定了如下四点，才能把01背包问题套到本题上来。
 *
 * 背包的体积为sum / 2
 * 背包要放入的商品（集合里的元素）重量为 元素的数值，价值也为元素的数值
 * 背包如果正好装满，说明找到了总和为 sum / 2 的子集。
 * 背包中每一个元素是不可重复放入。
 */
public class CanPartition {
    public boolean solution(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 == 1) return false;
        int target = sum / 2;

        int[] dp = new int[target +1];
        dp[0] = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j],dp[j - nums[i]] + nums[i]);
            }
        }
        if (dp[target] == target) return true;
        return false;
    }
}
