package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 摆动序列
 *
 * 如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为摆动序列。
 * 第一个差（如果存在的话）可能是正数或负数。少于两个元素的序列也是摆动序列。
 * 例如， [1,7,4,9,2,5] 是一个摆动序列，因为差值 (6,-3,5,-7,3) 是正负交替出现的。
 *
 * 给定一个整数序列，返回作为摆动序列的最长子序列的长度。
 * 通过从原始序列中删除一些（也可以不删除）元素来获得子序列，剩下的元素保持其原始顺序。
 *
 * 示例 1:
 *
 * 输入: [1,7,4,9,2,5]
 * 输出: 6
 * 解释: 整个序列均为摆动序列。
 *
 * 示例 2:
 * 输入: [1,17,5,10,13,15,10,5,16,8]
 * -+---++-+
 * 输出: 7
 * 解释: 这个序列包含几个长度为 7 摆动序列，其中一个可为[1,17,10,13,10,16,8]。
 *
 */
public class SwingSequence {

    // 保存符号，对符号去重
    public int solution1(int[] nums) {

        if (nums.length <= 1){
            return nums.length;
        }
        List<Character> res = new ArrayList<>();
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] > 0){
                res.add('+');
            }else if (nums[i] - nums[i - 1] < 0){
                res.add('-');
            }else {
                res.add('0');
            }
        }

        int size = res.size();
        for (int i = 0; i < size; i++) {
            if ((i >= 1 && res.get(i) == res.get(i - 1)) || res.get(i) == '0'){
                res.remove(i);
                size = res.size();
                i--;
            }
        }
        return res.size() + 1;
    }

    // 贪心
    //局部最优：删除单调坡度上的节点（不包括单调坡度两端的节点），那么这个坡度就可以有两个局部峰值。
    //整体最优：整个序列有最多的局部峰值，从而达到最长摆动序列。
    //情况一：上下坡中有平坡
    //情况二：数组首尾两端
    //情况三：单调坡中有平坡
    public int solution2(int[] nums) {
        if (nums.length <= 1) return nums.length;

        int curDiff = 0; // 当前一对差值
        int preDiff = 0; // 前一对差值
        int result = 1;  // 记录峰值个数，序列默认序列最右边有一个峰值(情况二)

        for (int i = 0; i < nums.length - 1; i++) {
            curDiff = nums[i + 1] - nums[i];
            // 出现峰值
            // preDiff = 0(情况一)
            if ((preDiff <= 0 && curDiff > 0) || (preDiff >= 0 && curDiff < 0)) {
                result++;
                preDiff = curDiff; // 只在摆动变化的时候更新prediff(情况三)
            }
        }
        return result;
    }
}
