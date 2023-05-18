package DynamicProgramming;

/**
 * 爬楼梯2
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1,2,3...m 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 */
public class ClimbStairs2 {
    public int solution(int n,int m){
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int j = 1; j <= n; j++) {
            for (int i = 1; i <= m; i++) {
                if (j - i >= 0) dp[j] += dp[j - i];
            }
        }

        return dp[n];
    }
}
