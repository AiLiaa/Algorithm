package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 子集2
 *
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 * 解集不能包含重复的子集。返回的解集中，子集可以按任意顺序排列。
 *
 * 示例 1：
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 *
 */
public class SubSets2 {

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] used;//去重

    public List<List<Integer>> solution(int[] nums) {
        if (nums.length == 0) return res;

        Arrays.sort(nums);
        used = new boolean[nums.length];
        Arrays.fill(used,false);

        backtracking(nums,0);
        return res;
    }

    public void backtracking(int[] nums, int index){
        res.add(new ArrayList<>(path));

        for (int i = index; i < nums.length; i++) {

            // used[i - 1] == true，说明同一树枝nums[i - 1]使用过
            // used[i - 1] == false，说明同一树层nums[i - 1]使用过
            // 要对同一树层使用过的元素进行跳过
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;

            path.add(nums[i]);
            used[i] = true;
            backtracking(nums,i + 1);
            path.removeLast();
            used[i] = false;
        }
    }
}
