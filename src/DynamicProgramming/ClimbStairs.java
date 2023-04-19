package DynamicProgramming;

/**
 * 爬楼梯
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 *
 *  * 1.确定dp数组（dp table）以及下标的含义
 *  ----下标：到第i阶楼梯 值：有多少种方法
 *  * 2.确定递推公式
 *  ----dp[i] = dp[i-1] + dp[i-2]
 *  * 3.dp数组如何初始化
 *  ----dp[1] = 1,dp[2] = 2
 *  * 4.确定遍历顺序
 *  ----前到后
 *  * 5.举例推导dp数组
 */
public class ClimbStairs {
    public int solution1(int n){
        if (n < 3) return n;

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    // 省空间
    public int solution2(int n) {
        if(n <= 2) return n;
        int a = 1, b = 2, sum = 0;

        for(int i = 3; i <= n; i++){
            sum = a + b;  // f(i - 1) + f(i - 2)
            a = b;        // 记录f(i - 1)，即下一轮的f(i - 2)
            b = sum;      // 记录f(i)，即下一轮的f(i - 1)
        }
        return b;
    }

    // 如果改题目，可以选择一次爬1到m阶
    public int climbStairs(int n,int m) {
        int[] dp = new int[n + 1];

        //这里并不是说明上第0阶有一种方法
        //而是当需要上的台阶i<m的时候，可以直接一下就上i阶楼梯了  dp[i] += dp[0]
        //并且dp[0] = 1，方便后续计算dp[m]和之前的dp[]值(因为前面m=2，所以直接初始化dp[1]和dp[2]了)
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) { // 把m换成2，就可以AC爬楼梯这道题
                if (i - j >= 0) dp[i] += dp[i - j];
            }
        }
        return dp[n];
    }
}
