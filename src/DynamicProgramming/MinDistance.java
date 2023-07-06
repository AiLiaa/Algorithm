package DynamicProgramming;

/**
 * 两个字符串的删除操作
 *
 * 给定两个单词 word1 和 word2，找到使得 word1 和 word2 相同所需的最小步数，每步可以删除任意一个字符串中的一个字符。
 *
 * 示例：
 * 输入: "sea", "eat"
 * 输出: 2
 * 解释: 第一步将"sea"变为"ea"，第二步将"eat"变为"ea"
 *
 */
public class MinDistance {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();

        //dp[i][j]表示以i-1为结尾的字符串word1，和以j-1位结尾的字符串word2，想要达到相等，所需要删除元素的最少次数。
        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i = 1; i <= len1; i++) {
            dp[i][0] = i;
        }

        for (int i = 1; i <= len2; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1];
                }else {
                    //情况一：删word1[i - 1]，最少操作次数为dp[i - 1][j] + 1
                    //情况二：删word2[j - 1]，最少操作次数为dp[i][j - 1] + 1
                    //情况三：同时删word1[i - 1]和word2[j - 1]，操作的最少次数为dp[i - 1][j - 1] + 2(一二中已经包含)
                    dp[i][j] = Math.min(dp[i - 1][j] + 1,dp[i][j - 1] + 1);
                }
            }
        }

        return dp[len1][len2];
    }
}
