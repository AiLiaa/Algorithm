package Greedy;

/**
 * 最大子序和
 *
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6
 *
 */
public class MaxSuborderSum {
    // 暴力
    public int solution1(int[] nums){
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int temp = 0;
            for (int j = i; j < nums.length; j++) {
                temp += nums[j];
                res = res > temp ? res : temp;
            }
        }
        return res;
    }

    //贪心
    public int solution2(int[] nums){
        int res = Integer.MIN_VALUE;
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            temp += nums[i];
            //大于就更新
            if (temp > res){
                res = temp;
            }
            // 小于0了，调整起始点，也就是归零，从i+1开始
            if (temp < 0){
                temp = 0;
            }
        }
        return res;
    }

    // 动态规划
    public int solution3(int[] nums){
        // 下标i之前的最大子序列和
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i],dp[i - 1] + nums[i]);
            if (res < dp[i]) res = dp[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        MaxSuborderSum maxSuborderSum = new MaxSuborderSum();
        int i = maxSuborderSum.solution3(nums);
        System.out.println(i);
    }
}
