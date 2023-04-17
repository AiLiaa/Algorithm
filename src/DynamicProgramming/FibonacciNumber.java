package DynamicProgramming;

/**
 * 斐波那契数
 *
 * 斐波那契数（通常用F(n) 表示）形成的序列称为 斐波那契数列 。
 * 该数列由0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * F(0) = 0，F(1)= 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 * 给定n ，请计算 F(n) 。
 *
 * 动态规划中每一个状态一定是由上一个状态推导出来的，这一点就区分于贪心，贪心没有状态推导，而是从局部直接选最优的
 *
 * 对于动态规划问题，拆解为如下五步：
 *
 * 1.确定dp数组（dp table）以及下标的含义
 * 2.确定递推公式
 * 3.dp数组如何初始化
 * 4.确定遍历顺序
 * 5.举例推导dp数组
 */
public class FibonacciNumber {
    public int solution(int n){
        if(n <= 1) return n;
        
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <=n ; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
