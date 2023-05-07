package Backtracking;

import java.util.*;

/**
 * 递增子序列
 *
 * 给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。
 * 你可以按 任意顺序 返回答案。
 *
 * 数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。
 *
 * 1 <= nums.length <= 15
 * -100 <= nums[i] <= 100
 *
 *
 */
public class IncrementalSubSequences {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> solution(int[] nums) {
        if (nums.length <= 1) return res;

        bacotracking(nums,0);
        return res;
    }
    public void bacotracking(int[] nums, int index){
        if (path.size() >= 2){
            res.add(new ArrayList<>(path));
        }

        // 在此定义used，因为used只记录本层元素是否重复使用，新的一层重置used
        int[] used = new int[201];// 使用数组来进行去重操作，题目说数值范围[-100, 100]
        for (int i = index; i < nums.length; i++) {
            if ((!path.isEmpty() && nums[i] < path.getLast())
                    || used[nums[i] + 100] == 1) continue;

            used[nums[i] + 100] = 1;// 记录这个元素在本层用过了，本层后面不能再用了
            path.add(nums[i]);
            bacotracking(nums,i + 1);
            path.removeLast();
        }
    }
}
