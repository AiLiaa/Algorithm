package Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 电话号码的字母组合
 *
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 示例:
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明：尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 *
 * 要解决如下问题：
 *
 * 数字和字母如何映射
 * 两个字母就两个for循环，三个字符我就三个for循环。回溯算法
 *
 */
public class AlphabeticCombinationsOfPhoneNumbers {
    List<String> res = new ArrayList<>();//存放结果集
    StringBuilder curStr = new StringBuilder();//存放当前结果

    public List<String> solution(String digits) {
        if (digits.length() == 0){
            return res;
        }
        // 二维数组映射字母和数字
        String[] numToStr =  {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backtracking(digits,0,numToStr);
        return res;
    }

    public void backtracking(String digits, int indexDigits, String[] numToStr){
        // 终止条件
        if (digits.length() == indexDigits){
            res.add(curStr.toString());
            return;
        }
        //s 表示当前num对应的字符串
        String s = numToStr[digits.charAt(indexDigits) - '0'];
        for (int i = 0; i < s.length(); i++) {
            curStr.append(s.charAt(i)); //处理
            backtracking(digits,indexDigits + 1,numToStr);  //递归
            curStr.deleteCharAt(curStr.length() - 1);   //回溯
        }
    }
}
