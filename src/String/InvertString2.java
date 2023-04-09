package String;

import java.util.Arrays;

/**
 * 字符串反转2
 *
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起, 每计数至 2k 个字符，就反转这 2k 个字符中的前 k 个字符。
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 *
 * 示例:
 * 输入: s = "abcdefg", k = 2
 * 输出: "bacdfeg"
 */

public class InvertString2 {

    public static String solution(String s, int k) {

        int length = s.length();
        char[] chars = s.toCharArray();

        for (int i = 0; i < length; i++) {
            int remainder = (i + 1) % (2 * k);
            if (remainder == 0) {
                int left = i + 1 - 2 * k;
                int right = i - k;
                swap(left,right,chars);
            }
        }
        // 处理尾部
        int remainder = length % (2 * k);
        if (remainder > 0 && remainder < k){
            swap(length - remainder,length - 1,chars);
        }
        if (remainder >= k && remainder < 2*k){
            swap(length - remainder,length - remainder + k - 1,chars);
        }
        return new String(chars);
    }

    // 交换
    public static void swap(int left, int right, char[] chars){
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        String res = solution("abcdefg", 2);
        System.out.println(res);
    }
}
