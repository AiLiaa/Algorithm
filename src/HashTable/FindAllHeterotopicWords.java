package HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 找到字符串中所有字母异位词
 *
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * 示例1:
 *
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 *
 */

public class FindAllHeterotopicWords {

    public static boolean isHeterotopicWord(String s, String t){
        int[] record = new int[26];
        int len_s = s.length();
        int len_t = t.length();

        for (int i = 0; i < len_s; i++) {
            record[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < len_t; i++) {
            record[t.charAt(i) - 'a']--;
        }
        for (int num : record) {
            if (num != 0){
                return false;
            }
        }
        return true;
    }

    // 暴力求解
    public static List<Integer> solution1(String s, String p) {
        List<Integer> list = new ArrayList<>();

        int len_p = p.length();
        int len_s = s.length();
        if (len_p > len_s){
            return list;
        }

        for (int i = 0; i < len_s - len_p + 1; i++) {
            if (isHeterotopicWord(s.substring(i, i + len_p), p)){
                list.add(i);
            }
        }
        return list;
    }

    /**
     * 滑动窗口
     *
     * 在字符串s 中构造一个长度为与字符串 p 的长度相同的滑动窗口，并在滑动中维护窗口中每种字母的数量；
     * 当窗口中每种字母的数量与字符串p 中每种字母的数量相同时，则说明当前窗口为字符串 p 的异位词。
     *
     * 使用数组来存储字符串 p 和滑动窗口中每种字母的数量。
     *
     */
    public static List<Integer> solution2(String s, String p) {
        List<Integer> list = new ArrayList<>();

        int len_p = p.length();
        int len_s = s.length();
        if (len_p > len_s){
            return list;
        }
        int[] countP = new int[26];
        int[] countS = new int[26];
        for (int i = 0; i < len_p; i++) {
            countP[p.charAt(i) - 'a']++;
            countS[s.charAt(i) - 'a']++;
        }
        if (Arrays.equals(countP,countS)){
            list.add(0);
        }
        for (int i = 0; i < len_s - len_p; i++) {
            countS[s.charAt(i) - 'a']--;
            countS[s.charAt(i + len_p) - 'a']++;
            if (Arrays.equals(countP,countS)){
                list.add(i + 1);
            }
        }
        return list;
    }

    public static void main(String[] args) {

        List<Integer> res = solution1("abcd", "ab");
        System.out.println(res);
    }
}
