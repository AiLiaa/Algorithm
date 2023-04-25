package DynamicProgramming;

import java.util.Arrays;

/**
 * 整数拆分
 *
 * 给定一个正整数n，将其拆分为 k 个正整数的和（k >= 2），并使这些整数的乘积最大化。
 * 返回 你可以获得的最大乘积。
 *
 * 示例 1:
 * 输入: n = 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 *
 * 示例2:
 * 输入: n = 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 ×3 ×4 = 36。
 *
 * 提示:
 * 2 <= n <= 58
 *
 */
public class IntegerBreak {
    // 动态规划, 拆分成两个数或者三个数
    public int solution1(int n){
        //dp[i] 为正整数 i 拆分后的结果的最大乘积
        int[] dp = new int[n+1];
        dp[2] = 1;
        for(int i = 3; i <= n; i++) {
            for(int j = 1; j <= i-j; j++) {
                // 这里的 j 其实最大值为 i-j,再大只不过是重复而已，
                //并且，在本题中，我们分析 dp[0], dp[1]都是无意义的，
                //j 最大到 i-j,就不会用到 dp[0]与dp[1]
                dp[i] = Math.max(dp[i], Math.max(j*(i-j), j*dp[i-j]));
                // j * (i - j) 是单纯的把整数 i 拆分为两个数 也就是 i,i-j ，再相乘
                //而j * dp[i - j]是将 i 拆分成两个以及两个以上的个数,再相乘。
            }
        }
        return dp[n];
    }

    // 贪心
    // 每次拆成n个3，如果剩下是4，则保留4，然后相乘，需要数学证明其合理性
    public int solution2(int n){
        if (n == 2) return 1;
        if (n == 3) return 2;
        if (n == 4) return 4;
        int result = 1;
        while (n > 4) {
            result *= 3;
            n -= 3;
        }
        result *= n;
        return result;
    }


    public static void main(String[] args) {
        IntegerBreak i = new IntegerBreak();
        int r = i.solution1(11);
        System.out.println(r);
    }
}
