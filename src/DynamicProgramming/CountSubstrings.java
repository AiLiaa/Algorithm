package DynamicProgramming;

/**
 * 回文子串
 *
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 *
 * 示例 1：
 * 输入："abc"
 * 输出：3
 * 解释：三个回文子串: "a", "b", "c"
 *
 * 示例 2：
 * 输入："aaa"
 * 输出：6
 * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
 * 提示：输入的字符串长度不会超过 1000 。
 *
 */
public class CountSubstrings {

    //动态规划
    public int countSubstrings(String s) {
        char[] chars = s.toCharArray();
        int length = s.length();

        //dp[i][j]表示s[i,j]区间的是否为回文子串
        boolean[][] dp = new boolean[length][length];

        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }

        int count = 0;

        //从下到上，从左到右遍历，这样保证dp[i + 1][j - 1]都是经过计算的。
        for (int i = length - 1; i >= 0; i--) {
            for (int j = i; j < length; j++) {
                if (chars[i] == chars[j]){
                    if (j - i >= 2){
                        dp[i][j] = dp[i + 1][j - 1];
                    }else {
                        //[a,a],[b]这些情况
                        dp[i][j] = true;
                    }
                    //回文串判断
                    if (dp[i][j]){
                        count++;
                    }
                }else {
                    dp[i][j] = false;
                }
            }
        }

        return count;
    }

    //中心扩散法
    public int countSubstrings2(String s) {
        int len, ans = 0;
        if (s == null || (len = s.length()) < 1) return 0;
        //总共有2 * len - 1个中心点
        for (int i = 0; i < 2 * len - 1; i++) {
            //通过遍历每个回文中心，向两边扩散，并判断是否回文字串
            //有两种情况，left == right，right = left + 1，这两种回文中心是不一样的
            int left = i / 2, right = left + i % 2;
            while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                //如果当前是一个回文串，则记录数量
                ans++;
                left--;
                right++;
            }
        }
        return ans;
    }

}
