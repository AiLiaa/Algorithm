package Backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 分割回文串
 *
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 * 返回 s 所有可能的分割方案。
 *
 * 示例: 输入: "aab" 输出: [ ["aa","b"], ["a","a","b"] ]
 */
public class SplitPalindromeString {
    List<List<String>> res = new ArrayList<>();
    LinkedList<String> path = new LinkedList<>();

    public List<List<String>> solution(String s) {
        if (s.length() == 0 || s.equals(" ")) return res;

        backtracking(s,0);
        return res;
    }
    public void backtracking(String s,int index){
        // 终止条件，遍历结束
        if (index >= s.length()){
            res.add(new ArrayList<>(path));
            return;
        }

        // index就像切割线
        // for横向，递归竖向
        for (int i = index; i < s.length(); i++) {
            if (!isPalindromeString(s,index,i)) {
                continue;
            }
            String temp = s.substring(index,i + 1);
            path.add(temp);
            backtracking(s,i + 1);
            path.removeLast();
        }
    }
    // 验证回文串 双指针
    public boolean isPalindromeString(String str,int start, int end){
        for (int i = start,j = end; i < j; i++,j--) {
            if (str.charAt(i) != str.charAt(j)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aaebb";
        SplitPalindromeString splitPalindromeString = new SplitPalindromeString();
        List<List<String>> res = splitPalindromeString.solution(s);
        System.out.println(res.toString());
    }
}
