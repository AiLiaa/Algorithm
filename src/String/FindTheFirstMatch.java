package String;

import java.util.Arrays;

/**
 * 找出字符串中第一个匹配项的下标
 *
 * 实现 strStr() 函数。
 *
 * 给定一个 haystack 字符串和一个 needle 字符串，
 * 在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * 示例 1: 输入: haystack = "hello", needle = "ll" 输出: 2
 * 示例 2: 输入: haystack = "aaaaa", needle = "bba" 输出: -1
 *
 * 说明: 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 *
 * KMP 经典题目
 * KMP的经典思想就是:当出现字符串不匹配时，可以记录一部分之前已经匹配的文本内容，利用这些信息避免从头再去做匹配。
 */

public class FindTheFirstMatch {

    public static int solution(String haystack, String needle) {
        int length1 = haystack.length();
        int length2 = needle.length();
        if (length2 == 0) return 0;
        int[] next = new int[length2];
        getNext(next,needle);
        System.out.println(Arrays.toString(next));

        // 定义两个下标  j指向模式串起始位置，i指向文本串起始位置。
        int j = 0;
        for (int i = 0; i < length1; i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j))
                j = next[j -1];
            if (haystack.charAt(i) == needle.charAt(j))
                j++;
            if (j == length2)
                return i - length2 + 1;
        }
        return -1;
    }

    // 前缀表
    //定义两个指针i和j，j指向前缀末尾位置，i指向后缀末尾位置。
    //next[i] 表示 i（包括i）之前最长相等的前后缀长度（其实就是j）
    public static void getNext(int[] next, String s){
        int j = 0;
        next[0] = j;
        int length = s.length();
        for (int i = 1; i < length; i++) { // i 从1开始
            //前后缀不相同了 j要保证大于0，因为下面有取j-1作为数组下标的操作
            while (j > 0 && s.charAt(i) != s.charAt(j))
                // 找前一位的对应的回退位置了（详细分析）
                // 假如串是aabaabaabb，next[0, 1, 0, 1, 2, 3, 4, 5, 6, 0]，在匹配最后一个字符b时
                // s.charAt(9) != s.charAt(6),之前的前缀加一个‘a’字符:aabaaba != aabaabb（匹配最后一个字符b）
                // 此时需要回退,找到j=6,也就是之前匹配的前缀aabaab，前一位就是整个尾b,根据这个b回退,b是j-1的下标号
                // 现在以这个b为后缀的尾部,找到他能匹配的前缀尾部位置,也就是j = next[j - 1]，j = next[5] = 3
                // 下标3之前的串是aab,最后一个字符b之前的aab刚好能匹配,这时回退了，再判断b != s.charAt(3)
                // 不相等，就再回退找前一位的对应的回退位置。相对就next[9] = j+1。就说明在b这个位置可以匹配4个字符的前缀
                j = next[j - 1];
            if (s.charAt(j) == s.charAt(i))
                j++;    // 找到相同的前后缀
            next[i] = j;    // 将j（前缀的长度）赋给next[i]
        }
    }

    public static void main(String[] args) {
        int res = solution("aabaabbaafagsdfsdfdafd", "aabaabaabb");
        System.out.println(res);
    }

}
