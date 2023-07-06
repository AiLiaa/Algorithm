package DynamicProgramming;

/**
 * 最长回文子序列
 *
 * 给定一个字符串 s ，找到其中最长的回文子序列，并返回该序列的长度。可以假设 s 的最大长度为 1000 。
 * 子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。
 *
 * 示例 1:
 * 输入: "bbbab"
 * 输出: 4 一个可能的最长回文子序列为 "bbbb"。
 *
 * 示例 2:
 * 输入:"cbbd"
 * 输出: 2 一个可能的最长回文子序列为 "bb"。
 *
 * 提示：
 * 1 <= s.length <= 1000
 * s 只包含小写英文字母
 *
 */
public class LongestPalindromeSubseq {
    public int longestPalindromeSubseq(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;

        //dp[i][j]：字符串s在[i, j]范围内最长的回文子序列的长度为dp[i][j]。
        int[][] dp = new int[length][length];

        for (int i = 0; i < length; i++) {
            dp[i][i] = 1;
        }

        for (int i = length - 1; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                if (chars[i] == chars[j]){
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                }else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            }
        }

        return dp[0][length - 1];
    }
}
