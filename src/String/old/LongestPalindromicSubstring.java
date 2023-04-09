package String.old;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 */

public class LongestPalindromicSubstring {
    /**
     * 方法一：动态规划
     *
     * 对于一个子串而言，如果它是回文串，并且长度大于 2,那么将它首尾的两个字母去除之后，它仍然是个回文串。
     * 例如对于字符串“ababa”，如果我们已经知道 “bab” 是回文串，那么 “ababa” 一定是回文串，
     * 这是因为它的首尾两个字母都是 “a”。
     */
    public static String longestPalindrome(String s){

        // 字符串只有一个字符，回文串是本身
        int lenth = s.length();
        if (lenth < 2){
            return s;
        }

        int maxLen = 1;
        int begin = 0;

        // 初始化dp[][],表示s[i,j]是否是回文串
        boolean[][] dp = new  boolean[lenth][lenth];
        for (int i = 0; i < lenth; i++) {
            dp[i][i] = true;
        }

        char[] chars = s.toCharArray();

        // 在判断串时，i是左边界，j是右边界
        for (int j = 1; j < lenth; j++) {
            for (int i = 0; i < j; i++) {

                if (chars[i] != chars[j]){
                    dp[i][j] = false;
                }else if (j - i < 3){
                    // 此时dp[i+1][j-1]还未赋值
                    dp[i][j] = true;
                }else {
                    // dp[i][j] = dp[i+1][j-1] && chars[i] == chars[j]
                    dp[i][j] = dp[i+1][j-1];
                }
                if (dp[i][j] && j - i + 1 > maxLen){
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin,begin+maxLen);
    }

    /**
     * 方法二：中心扩展法
     *
     * 从每一种边界情况开始「扩展」，也可以得出所有的状态对应的答案。
     * 边界情况即为子串长度为1或2的情况。
     * 枚举每一种边界情况，并从对应的子串开始不断地向两边扩展。
     * 如果两边的字母相同，就可以继续扩展
     *
     */
    public static String longestPalindrome02(String s){

        if (s.length() == 0 && s.equals("")){
            return "";
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s,i,i);
            int len2 = expandAroundCenter(s,i,i+1);
            int len = Math.max(len1, len2);
            if (len > end - start){
                start = i - (len - 1)/2;
                end = i + len/2;
            }
        }
        return s.substring(start,end+1);
    }

    public static int expandAroundCenter(String s, int left, int right){
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right - left - 1;
    }



    public static void main(String[] args) {
        String s = "qfaabcdcbaffevcacsw";
        String r = longestPalindrome02(s);
        System.out.println(r);
    }

}
