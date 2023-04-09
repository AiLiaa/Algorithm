package HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 四数之和
 *
 * 题意：给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，
 * 使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 *
 * 注意：
 * 答案中不可以包含重复的四元组。
 * 示例： 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * 满足要求的四元组集合为： [ [-1, 0, 0, 1], [-2, -1, 1, 2], [-2, 0, 0, 2] ]
 *
 * 双指针法
 */

public class SumOfFourNumbers {

    public List<List<Integer>> solution(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int length = nums.length;

        for (int k = 0; k < length; k++) {
            if (nums[k] > 0 && nums[k] > target){
                break;
            }
            if (k > 0 && nums[k] == nums[k - 1]){
                continue;//对a去重
            }

            for (int i = k + 1; i < length; i++) {
                if (nums[i] + nums[k] > 0 && nums[i] + nums[k] > target ){
                    break;
                }
                if (i > k + 1 && nums[i] == nums[i - 1]){
                    continue;//对b去重
                }
                int left = i + 1;
                int right = length - 1;
                while (left < right){
                    int sum = nums[k] + nums[i] + nums[left] + nums[right];
                    if (sum < target){
                        left++;
                    }else if (sum > target){
                        right--;
                    }else {
                        res.add(Arrays.asList(nums[k], nums[i], nums[left], nums[right]));
                        //对cd去重
                        while (left < right && nums[left] == nums[left+1]) left++;
                        while (left < right && nums[right] == nums[right-1]) right--;

                        right--;
                        left++;
                    }
                }
            }
        }
        return res;
    }
}
