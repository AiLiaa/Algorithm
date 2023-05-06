package Greedy;

import java.util.Arrays;

/**
 *  K 次取反后最大化的数组和
 *
 *  给你一个整数数组 nums 和一个整数 k ，按以下方法修改该数组：
 * 选择某个下标 i并将 nums[i] 替换为 -nums[i] 。
 * 重复这个过程恰好 k 次。可以多次选择同一个下标 i 。
 * 以这种方式修改数组后，返回数组 可能的最大和 。
 *
 * 示例 1：
 * 输入：nums = [4,2,3], k = 1
 * 输出：5
 * 解释：选择下标 1 ，nums 变为 [4,-2,3] 。
 *
 * 1 <= nums.length <= 104
 * -100 <= nums[i] <= 100
 * 1 <= k <= 104
 *
 * 遍历一次，取反最小的负数
 * 如果负数全处理完，k不为0，取反同一个最小正数
 */
public class MaxSumAfterKNegations {
    public int solution(int[] nums, int k) {
        Arrays.sort(nums);
        int minNum = Integer.MAX_VALUE;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0 && k > 0){
                nums[i] = -nums[i];
                k--;
            }
            sum += nums[i];
            minNum = minNum < nums[i] ? minNum : nums[i];
        }
        if (k > 0 && k % 2 == 1){
            sum -= 2 * minNum;
        }
        return sum;
    }
}
