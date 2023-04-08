package HashTable;

import java.util.HashMap;

/**
 *
 *
 * 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，
 * 判断第一个字符串 ransom 能不能由第二个字符串 magazines 里面的字符构成。
 * 如果可以构成，返回 true ；否则返回 false。
 *
 * (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。
 * 杂志字符串中的每个字符只能在赎金信字符串中使用一次。)
 *
 * 注意：
 * 你可以假设两个字符串均只含有小写字母。
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 */

public class RansomLetter {

    //HashMap
    public static boolean solution(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();
        int length2 = magazine.length();
        int length1 = ransomNote.length();

        for (int i = 0; i < length2; i++) {
            char c = magazine.charAt(i);
            map.put(c, map.getOrDefault(c,0)+1);
        }
        for (int i = 0; i < length1; i++) {
            char c = ransomNote.charAt(i);
            if (map.containsKey(c)){
                int temp = map.get(c);
                if (temp <= 0){
                    return false;
                }
                map.put(ransomNote.charAt(i),temp - 1);
            }else {
                return false;
            }
        }
        return true;
    }


    // 数组
    public static boolean solution2(String ransomNote, String magazine) {
        // 定义一个哈希映射数组
        int[] record = new int[26];

        // 遍历
        for(char c : magazine.toCharArray()){
            record[c - 'a'] += 1;
        }

        for(char c : ransomNote.toCharArray()){
            record[c - 'a'] -= 1;
        }

        // 如果数组中存在负数，说明ransomNote字符串总存在magazine中没有的字符
        for(int i : record){
            if(i < 0){
                return false;
            }
        }
        return true;
    }
}
