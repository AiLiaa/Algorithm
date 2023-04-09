package String;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 反翻转字符串中的单词
 *
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 *
 * 示例 1：
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 *
 * 示例 2：
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 *
 * 示例 3：
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 */

public class FlipWordsInString {

    // 遍历整个数组
    public static String solution1(String s){
        s = s.trim();// 去除首尾空格
        System.out.println(s);
        String res = "";
        int length = s.length();
        for (int i = length - 1; i > 0; i--) {
            if (s.charAt(i) == ' '){
                res += s.substring(i + 1,length) + " "; // 添加结果
                // 重构s
                s = s.substring(0,i).trim();
                length = s.length();
                i = length - 1;
            }
        }
        return res + s;
    }

    //对空格分割
    public static String solution2(String s){
        s = s.trim();
        String[] strs = s.split(" ");
        String res = "";
        int length = strs.length;
        for (int i = length - 1; i >= 0; i--) {
            if (strs[i].equals("")){
                continue;
            }
            res += strs[i].trim() + " ";
        }
        return res.substring(0,res.length()-1);
    }

    // 全api
    public static String solution3(String s){
        // 除去开头和末尾的空白字符
        s = s.trim();
        // 正则匹配连续的空白字符作为分隔符分割
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }


    public static void main(String[] args) {
        String s = "a good   example";
        String res = solution3(s);
        System.out.println(res);
    }
}
