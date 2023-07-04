package DynamicProgramming;

/**
 * 最大子序和
 *
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 * 提示：
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 *
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {

        //dp[i]表示以nums[i]结尾的连续子数组最大和
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i],dp[i - 1] + nums[i]);
            result = Math.max(result,dp[i]);
        }

        return result;
    }
}
