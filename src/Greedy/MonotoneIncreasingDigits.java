package Greedy;

/**
 * 单调递增的数字
 *
 * 给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
 * （当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）
 *
 * 示例 1:
 * 输入: N = 10
 * 输出: 9
 *
 * 示例 2:
 * 输入: N = 1234
 * 输出: 1234
 *
 * 示例 3:
 * 输入: N = 332
 * 输出: 299
 *
 * 说明: N 是在 [0, 10^9] 范围内的一个整数。
 *
 */
public class MonotoneIncreasingDigits {

    //递增区间保留，记录开始递减index，后面全是9
    public int monotoneIncreasingDigits(int n) {
        char[] chars = String.valueOf(n).toCharArray();
        if (chars.length == 1) return n;

        int res = chars[0] - '0';

        int index = 0;
        int same = 0;

        for (int i = 1; i < chars.length; i++) {
            //记录连续相同数字的个数(比如12333331 遇到1递减，前面的3都需要修改)
            if ( i > 1 && chars[i - 2] == chars[i - 1]){
                same++;
            }else {
                same = 0;
            }
            //递增
            if (chars[i] >= chars[i - 1]){
                res = (chars[i] - '0') + res * 10;
            }else {
                //递减
                if (same == 0){
                    res--;
                    index = i;
                }else {
                    String s = String.valueOf(res);
                    res = Integer.parseInt(s.substring(0, s.length() - same)) - 1;
                    index = i - same;
                }
                break;
            }
        }
        //有递减情况，后面填充9
        if (index != 0){
            for (int i = index; i < chars.length; i++) {
                res = res * 10 + 9;
            }
        }
        return res;
    }

    //从后向前遍历，找到需要赋值9的位置
    public int monotoneIncreasingDigits1(int n) {
        String s = String.valueOf(n);
        char[] chars = s.toCharArray();
        int start = s.length();
        for (int i = s.length() - 2; i >= 0; i--) {
            if (chars[i] > chars[i + 1]) {
                chars[i]--;
                start = i+1;
            }
        }
        for (int i = start; i < s.length(); i++) {
            chars[i] = '9';
        }
        return Integer.parseInt(String.valueOf(chars));
    }
}
