package HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 字母异位词分组
 *
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。
 *
 * 示例 1:
 *
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * 示例 2:
 *
 * 输入: strs = [""]
 * 输出: [[""]]
 * 示例 3:
 *
 * 输入: strs = ["a"]
 * 输出: [["a"]]
 *
 */

public class HeterotopicWordGroup {

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

    // 暴力解法
    public static List<List<String>> solution1(String[] strs) {
        List<String> list = new ArrayList<>();
        List<List<String>> lists = new ArrayList<>();

        int length = strs.length;

        list.add(strs[0]);
        lists.add(list);

        if (length == 1){
            return lists;
        }

        boolean flag;


        for (int i = 1; i < length; i++) {
            flag = true;

            for (List l : lists) {
                if (isHeterotopicWord(l.get(0).toString(), strs[i])){
                    l.add(strs[i]);
                    flag = false;
                    break;
                }
            }
            if (flag){
                List<String> listAdd = new ArrayList<>();
                listAdd.add(strs[i]);
                lists.add(listAdd);
            }
        }

        return lists;
    }

    /**
     * 排序
     *
     * 互为字母异位词的两个字符串包含的字母相同，因此对两个字符串分别进行排序之后得到的字符串一定是相同的，
     * 可以将排序之后的字符串作为哈希表的键。
     */
    public static List<List<String>> solution2(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> val = map.getOrDefault(key, new ArrayList<String>());
            val.add(str);
            map.put(key,val);
        }
        return new ArrayList<List<String>>(map.values());
    }

    /**
     * 两个字符串中的相同字母出现的次数一定是相同的，故可以将每个字母出现的次数使用字符串表示，作为哈希表的键。
     * 由于字符串只包含小写字母，因此对于每个字符串，可以使用长度为 26 的数组记录每个字母出现的次数。
     *
     */
    public static List<List<String>> solution3(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] count = new int[26];
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char c = str.charAt(i);
                count[c - 'a']++;
            }
            // 将每个出现次数大于 0 的字母和出现次数按顺序拼接成字符串，作为哈希表的键
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (count[i] != 0){
                    stringBuilder.append((char)(i + 'a'));
                    stringBuilder.append(count[i]);
                }
            }

            String key = new String(stringBuilder);
            List<String> val = map.getOrDefault(key, new ArrayList<String>());
            val.add(str);
            map.put(key, val);
        }
        return new ArrayList<List<String>>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = solution1(strs);
        for (List list: lists) {
            System.out.print(Arrays.toString(list.toArray()) + " ");
        }
    }
}
