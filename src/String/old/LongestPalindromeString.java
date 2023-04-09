package String.old;


import java.util.HashSet;

/**
 * 最长的回文串长度
 *
 * LeetCode: 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 * 在构造过程中，请注意区分大小写。比如"Aa"不能当做一个回文字符串。注 意:假设字符串的长度不会超过 1010。
 * 回文串：“回文串”是一个正读和反读都一样的字符串，比如“level”或者“noon”等等就是回文串。
 *
 * 可以构成回文串的两种情况：
 * 字符出现次数为双数的组合
 * 字符出现次数为偶数的组合+单个字符中出现次数最多且为奇数次的字符
 *
 * 统计字符出现的次数即可，双数才能构成回文。因为允许中间一个数单独出现，比如“abcba”，所以如果最后有字母落单，总长度可以加 1。
 * 首先将字符串转变为字符数组。然后遍历该数组，判断对应字符是否在hashset中，如果不在就加进去，如果在就让count++，然后移除该字符！这样就能找到出现次数为双数的字符个数。
 */
public class LongestPalindromeString {
    public int solution(String str){

        if (str.equals(" ")){
            return 0;
        }

        HashSet<Character> hashSet = new HashSet<Character>();

        int count = 0;

        for (int i = 0; i < str.length(); i++){
            if (!hashSet.contains(str.charAt(i))){
                hashSet.add(str.charAt(i));
            }else {
                hashSet.remove(str.charAt(i));
                count++;
            }
        }

        return hashSet.isEmpty() ? 2*count : 2*count + 1;
    }

    public static void main(String[] args) {
        LongestPalindromeString longestPalindromeString = new LongestPalindromeString();

        String s = "accdfvcsa";

        int i = longestPalindromeString.solution(s);

        System.out.println(i);

    }
}
