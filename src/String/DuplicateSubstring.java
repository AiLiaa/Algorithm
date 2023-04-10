package String;

import java.util.Arrays;

/**
 * 重复的子字符串
 *
 * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。
 * 给定的字符串只含有小写英文字母，并且长度不超过10000。
 *
 * 示例 1:
 * 输入: "abab"
 * 输出: True
 * 解释: 可由子字符串 "ab" 重复两次构成。
 *
 * 示例 2:
 * 输入: "aba"
 * 输出: False
 *
 * 示例 3:
 * 输入: "abcabcabcabc"
 * 输出: True
 * 解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
 */

public class DuplicateSubstring {

    // API解法 拼接后去头尾，判断s1中是否含有s(重复串的特点)
    public static boolean solution1(String s) {

        String s1 = s + s;
        int length = s1.length();
        String substring = s1.substring(1, length - 1);
        System.out.println(substring);
        boolean contains = substring.contains(s);
        return contains;

    }

    // KMP 对next中的数组判断，取最后一位数组的值last，
    // len - last如果能被len整除，且last大于0，说明len - last长度的串重复
    public static boolean solution2(String s){
        int length = s.length();
        int[] next = new int[length];
        int j = 0;
        next[0] = j;

        for (int i = 1; i < length; i++) {
            while (j > 0 && s.charAt(j) != s.charAt(i)){
                j = next[j - 1];
            }
            if (s.charAt(j) == s.charAt(i)){
                j++;
            }
            next[i] = j;
        }
        int last = next[length - 1];
        return length % (length - last) == 0 && last > 0;
    }

    public static void main(String[] args) {
        boolean r = solution2("abcabc");
        System.out.println(r);
    }
}
