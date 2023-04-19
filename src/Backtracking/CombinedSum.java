package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 组合总和
 *
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。
 *
 * 示例 1：
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为： [ [7], [2,2,3] ]
 *
 */
public class CombinedSum {
    public List<List<Integer>> res = new ArrayList<>();//存放结果集
    public LinkedList<Integer> path = new LinkedList<>();//存放当前结果

    public List<List<Integer>> solution(int[] candidates, int target) {
        backtracking(candidates,target,0,0);
        return res;
    }

    public void backtracking(int[] candidates,int target,int sum,int startIndex){
        if (sum > target){
            return;
        }

        if (sum == target){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            path.add(candidates[i]);
            sum += candidates[i];
            backtracking(candidates,target,sum,i);
            path.removeLast();
            sum -= candidates[i];
        }
    }
}
