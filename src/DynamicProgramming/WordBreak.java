package DynamicProgramming;

import java.util.Arrays;
import java.util.List;

/**
 * 单词拆分
 *
 * 给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 * 说明：
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 *
 * 示例 1：
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 * 示例 2：
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 * 注意你可以重复使用字典中的单词。
 * 示例 3：
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 *
 * 提示：
 * 1 <= s.length <= 300
 * 1 <= wordDict.length <= 1000
 * 1 <= wordDict[i].length <= 20
 * s 和 wordDict[i] 仅有小写英文字母组成
 * wordDict 中的所有字符串 互不相同
 *
 */
public class WordBreak {
    public boolean solution(String s, List<String> wordDict) {
        int length = s.length();

        boolean[] dp = new boolean[length + 1];
        Arrays.fill(dp,false);
        dp[0] = true;

        int size = wordDict.size();
        //先遍历背包
        for (int i = 1; i <= length; i++) {
            for (int j = 0; j < size; j++) {
                int length1 = wordDict.get(j).length();
                //当子串相同时
                if (i - length1 >= 0 && s.substring(i - length1,i).equals(wordDict.get(j))){
                    dp[i] |= dp[i - length1];
                }
            }
        }
        return dp[length];
    }
}
