package DynamicProgramming;

/**
 * 不同路径2
 *
 * 一个机器人位于一个m x n网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 *
 */
public class DifferentPaths2 {

    public int solution(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        // 起点 右下角是障碍物
        if (obstacleGrid[m - 1][n - 1] == 1 || obstacleGrid[0][0] == 1) return 0;

        int[][] dp = new int[m][n];

        // 初始化
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) break;//遇到障碍物
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1) break;//遇到障碍物
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
//                //上面 左边有障碍物
//                if (obstacleGrid[i - 1][j] == 1 && obstacleGrid[i][j - 1] == 1){
//                    dp[i][j] = 0;
//                    continue;
//                }
//                //上面有障碍物
//                if (obstacleGrid[i - 1][j] == 1){
//                    dp[i][j] = dp[i][j - 1];
//                    continue;
//                }
//                //左边有障碍物
//                if (obstacleGrid[i][j - 1] == 1){
//                    dp[i][j] = dp[i - 1][j];
//                    continue;
//                }
                // 遇到障碍物，置0
                if (obstacleGrid[i][j] == 1) continue;

                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

}
