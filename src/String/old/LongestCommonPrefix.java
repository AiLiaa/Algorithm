package String.old;

import java.util.Arrays;

/**
 * 最长公共前缀
 *
 * Leetcode: 编写一个函数来查找字符串数组中的最长公共前缀。如果不存在公共前缀，返回空字符串 ""。
 *
 * 思路：
 * 先利用Arrays.sort(strs)为数组排序，再将数组第一个元素和最后一个元素的字符从前往后对比即可
 */
public class LongestCommonPrefix {

    public String solution(String[] str){

        int lenth = str.length;

        if (lenth == 0){
            return "";
        }

        StringBuilder res = new StringBuilder();

        Arrays.sort(str);
        for (int i = 0;i<str.length;i++){
            System.out.print(str[i] +" ");
        }

        int n = str[0].length();
        int m = str[lenth-1].length();
        int r = Math.min(n,m);

        for (int i = 0; i<r; i++){
            if (str[0].charAt(i) == str[lenth-1].charAt(i)){
                res.append(str[0].charAt(i));
            }else {
                break;
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();

        String[] strings = {"1asfe", "1avd", "1afv3", "1a51", "5"};

        String r = longestCommonPrefix.solution(strings);

        System.out.println();
        System.out.println(r);
    }


}
