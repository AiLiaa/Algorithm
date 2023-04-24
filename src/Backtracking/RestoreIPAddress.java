package Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 复原IP地址
 *
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * 有效的 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效的 IP 地址，
 * 但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效的 IP 地址。
 *
 * 示例 1：
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 *
 * 示例 2：
 * 输入：s = "0000"
 * 输出：["0.0.0.0"]
 */
public class RestoreIPAddress {
    List<String> res = new ArrayList<>();
    int count = 0;// "."的数目

    public List<String> solution(String s) {
        if (s.length() > 12) return res;
        backtracking(s,0);
        return res;
    }

    public void backtracking(String s,int startIndex){
        // 结束条件
        if (count == 3){
            // 最后一段合法就放进去
            if (isValid(s,startIndex,s.length() - 1)){
                res.add(s);
            }
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            if (isValid(s,startIndex,i)){
                s = s.substring(0,i + 1) + "." + s.substring(i + 1);
                count++;
                backtracking(s,i + 2);//加入"."后从i+2递归
                s = s.substring(0,i + 1) + s.substring(i + 2);
                count--;
            }else {
                break;
            }
        }
    }

    // 判断合法
    public boolean isValid(String s,int start,int end){
        if (start > end) return false;
        if (s.charAt(start) == '0' && start != end) return false; // 0开头
        String substring = s.substring(start, end + 1);
        if (!substring.equals("") && Long.parseLong(substring) > 255l){
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        String s = "25525511135";
        RestoreIPAddress restoreIPAddress = new RestoreIPAddress();
        List<String> r = restoreIPAddress.solution(s);
        System.out.println(r);
    }



    //方法二：比上面的方法时间复杂度低，更好地剪枝，优化时间复杂度
    List<String> result = new ArrayList<String>();
    StringBuilder stringBuilder = new StringBuilder();

    public List<String> solution2(String s) {
        restoreIpAddressesHandler(s, 0, 0);
        return result;
    }

    // number表示stringbuilder中ip段的数量
    public void restoreIpAddressesHandler(String s, int start, int number) {
        // 如果start等于s的长度并且ip段的数量是4，则加入结果集，并返回
        if (start == s.length() && number == 4) {
            result.add(stringBuilder.toString());
            return;
        }
        // 如果start等于s的长度但是ip段的数量不为4，或者ip段的数量为4但是start小于s的长度，则直接返回
        if (start == s.length() || number == 4) {
            return;
        }
        // 剪枝：ip段的长度最大是3，并且ip段处于[0,255]
        for (int i = start; i < s.length() && i - start < 3 && Integer.parseInt(s.substring(start, i + 1)) >= 0
                && Integer.parseInt(s.substring(start, i + 1)) <= 255; i++) {
            // 如果ip段的长度大于1，并且第一位为0的话，continue
            if (i + 1 - start > 1 && s.charAt(start) - '0' == 0) {
                continue;
            }
            stringBuilder.append(s.substring(start, i + 1));
            // 当stringBuilder里的网段数量小于3时，才会加点；如果等于3，说明已经有3段了，最后一段不需要再加点
            if (number < 3) {
                stringBuilder.append(".");
            }
            number++;
            restoreIpAddressesHandler(s, i + 1, number);
            number--;
            // 删除当前stringBuilder最后一个网段，注意考虑点的数量的问题
            stringBuilder.delete(start + number, i + number + 2);
        }
    }
}
