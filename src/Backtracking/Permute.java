package Backtracking;

import java.util.*;

/**
 * 全排列
 *
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例
 * 输入: [1,2,3]
 * 输出: [ [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1] ]
 *
 * 元素1在[1,2]中已经使用过了，但是在[2,1]中还要在使用一次1，处理排列问题就不用使用startIndex了。
 * 排列问题需要一个used数组，标记已经选择的元素
 */
public class Permute {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    int[] used;

    public List<List<Integer>> solution(int[] nums) {
        if (nums.length == 0) return res;
        used = new int[nums.length];
        backtracking(nums);
        return res;
    }

    public void backtracking(int[] nums){
        if (path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i] == 1) continue;
            used[i] = 1;
            path.add(nums[i]);

            backtracking(nums);

            path.removeLast();
            used[i] = 0;
        }
    }
}
