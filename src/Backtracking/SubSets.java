package Backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 子集
 *
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 * 示例: 输入: nums = [1,2,3] 输出: [[3],[1],[2],[1,2,3],[1,3],[2,3],[1,2],[] ]
 *
 */
public class SubSets {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> solution(int[] nums) {
        if (nums.length == 0) return res;
        backtracking(nums, 0);
        return res;
    }
    public void backtracking(int[] nums, int index){
        res.add(new ArrayList<>(path));

        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            backtracking(nums,i + 1);
            path.removeLast();
        }
    }
}
