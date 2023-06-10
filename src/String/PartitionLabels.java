package String;

import java.util.ArrayList;

/**
 * 划分字母区间
 *
 * 给你一个字符串 s 。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。
 * 注意，划分结果需要满足：将所有划分结果按顺序连接，得到的字符串仍然是 s 。
 * 返回一个表示每个字符串片段的长度的列表。
 *
 * 数组记录每个字母最后出现的位置
 * end记录需要划分的位置
 * end = Math.max(lastWord[s.charAt(i) - 'a'], end);
 * i == end时确定要划分一次
 */
public class PartitionLabels {

    public ArrayList<Integer> solution (String s) {

        int[] lastWord = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastWord[s.charAt(i) - 'a'] = i;
        }
        ArrayList<Integer> res = new ArrayList<>();
        int begin = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(lastWord[s.charAt(i) - 'a'], end);
            if (i == end){
                res.add(end - begin + 1);
                begin = end + 1;
            }
        }
        return res;
    }
}
