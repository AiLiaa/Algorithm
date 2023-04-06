package String;

/**
 * 最长回文子序列长度
 *
 * LeetCode: 最长回文子序列 给定一个字符串s，找到其中最长的回文子序列。
 * 可以假设s的最大长度为1000。 最长回文子序列和上一题最长回文子串的区别是，
 * 子串是字符串中连续的一个序列，而子序列是字符串中保持相对位置的字符序列，
 * 例如，"bbbb"可以是字符串"bbbab"的子序列但不是子串。
 *
 */

public class LongestPalindromeSubsequence {

    /**
     * 动态规划
     * 对于一个子序列而言，如果它是回文子序列，并且长度大于2，那么将它首尾的两个字符去除之后，它仍然是个回文子序列。
     * 因此可以用动态规划的方法计算给定字符串的最长回文子序列。
     * 用dp[][]表示字符串s的下标范围[i,j]内的最长回文子序列的长度。
     * 假设字符串s的长度为n，则只有当0≤i≤j<n时，才会有dp[i][j]>0，否则dp[i][j]=0。
     *
     * 如果s[i]= s[j]，则首先得到s的下标范围[i＋1,j一1]内的最长回文子序列，
     * 然后在该子序列的首尾分别添加s[i]和s[j]，即可得到s的下标范围[i,i]内的最长回文子序列，
     * 因此 dp[i][j]= dp[i＋1][j-1]＋2;
     *
     * 如果s[i]≠ s[j]，则s[i]和s[j]不可能同时作为同一个回文子序列的首尾，
     * 因此 dp[i][j]= max( dp[i＋1][j], dp[i][j - 1])。
     *
     * 由于状态转移方程都是从长度较短的子序列向长度较长的子序列转移，因此需要注意动态规划的循环顺序。
     * int i = length-1; i >= 0; i--
     * dp[i][j] = dp[i+1][j-1] + 2
     *
     */
    public static int longestPalindromeSubseq(String s){

        int length = s.length();

        int[][] dp = new int[length][length];

        for (int i = length-1; i >= 0; i--) {
            dp[i][i] = 1;
            char c = s.charAt(i);
            for (int j = i+1; j < length; j++) {
                char c1 = s.charAt(j);
                if (c == c1){
                    dp[i][j] = dp[i+1][j-1] + 2;
                }else {
                    dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
                }
            }
        }
        return dp[0][length-1];
    }

    public static void main(String[] args) {
        String s = "abcdaba";
        int i = longestPalindromeSubseq(s);
        System.out.println(i);
    }

}
