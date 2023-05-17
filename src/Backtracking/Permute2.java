package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 全排列 II
 *
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 *
 * 示例 1：
 * 输入：nums = [1,1,2]
 * 输出： [[1,1,2], [1,2,1], [2,1,1]]
 *
 * 示例 2：
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 提示：
 *
 * 1 <= nums.length <= 8
 * -10 <= nums[i] <= 10
 *
 */
public class Permute2 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    int[] used;

    public List<List<Integer>> solution(int[] nums){
        if (nums.length == 0) return res;
        used = new int[nums.length];
        Arrays.sort(nums);
        backtracking(nums);
        return res;
    }

    public void backtracking(int[] nums){
        if (path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // used[i - 1] == 1，说明同一树枝nums[i - 1]使用过
            // used[i - 1] == 0，说明同一树层nums[i - 1]使用过
            //对同层去除相等元素 || 对不同层去除已使用元素
            if ((i > 0 && nums[i - 1] == nums[i] && used[i - 1] == 0) || used[i] == 1) continue;
            path.add(nums[i]);
            used[i] = 1;
            backtracking(nums);
            path.removeLast();
            used[i] = 0;
        }
    }
}
