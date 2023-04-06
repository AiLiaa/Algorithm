package Array.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 最小覆盖子串
 *
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。
 * 如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 *
 * 注意：
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 *
 * 示例 1：
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
 *
 */

public class MinimumCoverSubstring {

    // 超时
    public static String solution(String s, String t){
        int i = 0;
        int t_len = t.length();
        int s_len = s.length();
        int minLen = Integer.MAX_VALUE;
        boolean temp = true;

        if (s_len < t_len){
            return "";
        }
        if (s.equals(t)){
            return s;
        }

        // 移动窗口中，t串的字符出现的次数 key字符 value次数
        Map<Character, Integer> map = new HashMap<>();

        for (int j = 0; j < t_len; j++) {
            map.put(t.charAt(j), 0);
        }

        // t串的字符出现的次数计数 key字符 value次数
        Map<Character, Integer> count = new HashMap<>();
        for (int j = 0; j < t_len; j++) {
            count.put(t.charAt(j), count.getOrDefault(t.charAt(j), 0) + 1);
        }

        // 符合条件的最短的串长度 最短串的起始
        Map<Integer, Integer> indexAndMinLength = new HashMap<>();

        for (int j = 0; j < s_len; j++) {
            // s串窗口中含有t中的字符，该字符key的value+1
            if (map.containsKey(s.charAt(j))){
                map.put(s.charAt(j), map.get(s.charAt(j)) + 1);
            }
            boolean flag = true;
            if (map.containsValue(0)){
                continue;
            }
            // 这里很超时
            for (int k = 0; k < t_len; k++) {
                temp = map.get(t.charAt(k)) < count.get(t.charAt(k)) ? false : true;
                flag = temp & flag;
            }
            // 遍历s,当t的字符在s窗口中都出现时
            if (flag){
                // 遍历窗口,移动i
                for (int k = i; k < j; k++) {
                    // s中的字符不属于t，指针i++
                    if (map.get(s.charAt(k)) == null){
                        i++;
                    }else {
                        if (map.get(s.charAt(k)) == count.get(s.charAt(k))){ // 此时保证窗口中包含t字符,i不能++
                            break;
                        }
                        // s的字符在t中，如果窗口中有两个或以上这样的字符，去掉一个这样的字符,i++
                        if (map.get(s.charAt(k)) > count.get(s.charAt(k))){
                            map.put(s.charAt(k), map.get(s.charAt(k)) - 1);
                            i++;
                        }else { // map.get(s.charAt(k)) != null && map.get(s.charAt(k)) < count.get(s.charAt(k))
                            break;
                        }
                    }
                }
                indexAndMinLength.put(j - i + 1, i);
            }
        }
        if (indexAndMinLength.isEmpty()){
            return "";
        }
        // 遍历indexAndMinLength，找到最短串
        for (Map.Entry<Integer, Integer> entry : indexAndMinLength.entrySet()) {
            Integer mapKey = entry.getKey();
            minLen = minLen < mapKey ? minLen : mapKey;
        }

        return s.substring(indexAndMinLength.get(minLen), minLen + indexAndMinLength.get(minLen));
    }




    public static String solution2(String s, String t){
        if (s == null || s.length() == 0 || t == null || t.length() == 0){
            return "";
        }
        int[] need = new int[128];
        //记录需要的字符的个数
        for (int i = 0; i < t.length(); i++) {
            need[t.charAt(i)]++;
        }
        //l是当前左边界，r是当前右边界，size记录可行窗口大小，count是需求的字符个数，start是最小覆盖串开始的index
        int l = 0, r = 0, size = Integer.MAX_VALUE, count = t.length(), start = 0, s_len = s.length();
        //遍历所有字符
        while (r < s_len) {
            char c = s.charAt(r);
            if (need[c] > 0) {//需要字符c
                count--;
            }
            need[c]--;//把右边的字符加入窗口
            if (count == 0) {//窗口中已经包含所有字符
                // 这里while 比如窗口:aaabc t:abc,这时要去掉两个a,左指针右移
                while (l < r && need[s.charAt(l)] < 0) {
                    need[s.charAt(l)]++;//释放左边移动出窗口的字符
                    l++;//指针右移
                }
                if (r - l + 1 < size) {//不能右移时候挑战最小窗口大小，更新最小窗口开始的start
                    size = r - l + 1;
                    start = l;//记录下最小值时候的开始位置，最后返回覆盖串时候会用到
                }
                //l向右移动后窗口肯定不能满足了 重新开始循环
                need[s.charAt(l)]++;
                l++;
                count++;
            }
            r++;
        }
        return size == Integer.MAX_VALUE ? "" : s.substring(start, start + size);
    }



    public static void main(String[] args) {

        String s = "ADOBECODEBANC";
        String t = "ABC";
        String r = solution2(s, t);
        System.out.println("r:"+r);
    }

}
