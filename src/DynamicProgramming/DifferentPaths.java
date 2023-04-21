package DynamicProgramming;

import java.util.Arrays;

/**
 * 不同路径
 *
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * 问总共有多少条不同的路径？
 *
 * 输入：m = 3, n = 7
 * 输出：28
 *
 */
public class DifferentPaths {

    public static int solution(int m, int n) {
        // 走到m行n列的路径数
        int[][] dp = new int[m + 1][n + 1];
        //初始化左和上格子的路径数目
        for (int i = 1; i <= m; i++) {
            dp[i][1] = 1;
        }
        for (int i = 1; i <= n; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= m; i++) {
            for (int j = 2; j <= n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        // 输出左和上应该是初始化的全1
        for (int[] date : dp){

            System.out.println(Arrays.toString(date));
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        int r = solution(3, 7);
        System.out.println(r);
    }
}
