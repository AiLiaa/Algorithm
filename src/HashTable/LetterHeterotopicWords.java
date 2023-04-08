package HashTable;

/**
 * 有效字母异位词
 *
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 示例 1: 输入: s = "anagram", t = "nagaram" 输出: true
 * 示例 2: 输入: s = "rat", t = "car" 输出: false
 *
 * 说明: 你可以假设字符串只包含小写字母。
 *
 * 用数组记录s的字符出现次数，任何减去t中字符的出现次数
 * 数组下标：record[s.charAt(i) - 'a'] 相对值
 */

public class LetterHeterotopicWords {

    public static boolean solution(String s, String t){
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

}
