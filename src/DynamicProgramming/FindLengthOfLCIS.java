package DynamicProgramming;

import java.util.Arrays;

/**
 * 最长连续递增序列
 *
 * 给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。
 * 连续递增的子序列 可以由两个下标 l 和 r（l < r）确定，如果对于每个 l <= i < r，都有 nums[i] < nums[i + 1] ，
 * 那么子序列 [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] 就是连续递增子序列。
 *
 * 示例 1：
 * 输入：nums = [1,3,5,4,7]
 * 输出：3
 * 解释：最长连续递增序列是 [1,3,5], 长度为3。
 * 尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为 5 和 7 在原数组里被 4 隔开。
 *
 * 示例 2：
 * 输入：nums = [2,2,2,2,2]
 * 输出：1
 * 解释：最长连续递增序列是 [2], 长度为1。
 *
 * 提示：
 * 0 <= nums.length <= 10^4
 * -10^9 <= nums[i] <= 10^9
 *
 */
public class FindLengthOfLCIS {

    //暴力解法
    public int findLengthOfLCIS(int[] nums) {
        int res = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            int len = 1;
            for (int j = i; j < nums.length - 1; j++) {
                if (nums[j] < nums[j + 1]){
                    len ++;
                }else {
                    break;
                }
            }
            res = Math.max(len,res);
        }

        return res;
    }

    //动态规划
    public int findLengthOfLCIS1(int[] nums) {

        //以i结尾的最长连续递增序列
        int[] dp = new int[nums.length];

        Arrays.fill(dp,1);
        int result = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]){
                dp[i] = dp[i - 1] + 1;
            }
            result = Math.max(result,dp[i]);
        }

        return result;
    }

}
