package DynamicProgramming;

/**
 * 不同的子序列
 *
 * 给定一个字符串 s 和一个字符串 t ，计算在 s 的子序列中 t 出现的个数。
 * 题目数据保证答案符合 32 位带符号整数范围。
 *
 * 示例1：
 * 输入：s = "rabbbit", t = "rabbit"
 * 输出：3
 * 解释：
 * 如下所示, 有 3 种可以从 s 中得到 "rabbit" 的方案。
 * ra bb bit
 * rab bb it
 * rab b bit
 *
 */
public class NumDistinct {
    public int numDistinct(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();

        //dp[i][j]：以i-1为结尾的s子序列中出现以j-1为结尾的t的个数为dp[i][j]。
        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i = 0; i <= len1; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)){
                    //一部分是用s[i - 1]来匹配，那么个数为dp[i - 1][j - 1]。
                    // 即不需要考虑当前s子串和t子串的最后一位字母，所以只需要 dp[i-1][j-1]。
                    // 一部分是不用s[i - 1]来匹配，个数为dp[i - 1][j]。
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }else {
                    // 当s[i - 1] 与 t[j - 1]不相等时，dp[i][j]只有一部分组成，
                    // 不用s[i - 1]来匹配（就是模拟在s中删除这个元素），即：dp[i - 1][j]
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[len1][len2];
    }
}
