package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明： 所有数字（包括目标数）都是正整数。解集不能包含重复的组合。
 *
 */

public class CombinedSum2 {
    public List<List<Integer>> res = new ArrayList<>();//存放结果集
    public LinkedList<Integer> path = new LinkedList<>();//存放当前结果
    boolean[] used;// 判断前一个相同值是否在同一层使用过。去重

    public List<List<Integer>> solution(int[] candidates, int target) {
        // 排序，方便去重
        Arrays.sort(candidates);
        used = new boolean[candidates.length];
        Arrays.fill(used,false);

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
            // 剪枝
            if (sum + candidates[i] > target) {
                break;
            }
            // 出现重复节点，同层的上一个相同节点已经被访问过，所以直接跳过
            if (i > 1 && candidates[i] == candidates[i - 1] && !used[i - 1]) continue;

            path.add(candidates[i]);
            sum += candidates[i];
            used[i] = true;

            // 递归
            backtracking(candidates,target,sum,i + 1);

            // 回溯
            used[i] = false;
            path.removeLast();
            sum -= candidates[i];
        }
    }
}
