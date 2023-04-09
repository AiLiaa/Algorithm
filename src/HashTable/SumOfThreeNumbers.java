package HashTable;

import java.util.*;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意： 答案中不可以包含重复的三元组。
 * 示例：
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 满足要求的三元组集合为： [ [-1, 0, 1], [-1, -1, 2] ]
 *
 */

public class SumOfThreeNumbers {

    // 哈希
    public static List<List<Integer>> solution1(int[] nums){
        Arrays.sort(nums);// 排序，方便去重
        List<List<Integer>> res = new ArrayList<>();

        int length = nums.length;

        for (int i = 0; i < length; i++) {
            if (nums[i] > 0){
                break;// 第一个元素大于0,不可能组成符合的三元组
            }
            if (i > 0 && nums[i] == nums[i - 1]){
                continue;//对第一个元素去重(不能有重复的三元组，但三元组内的元素是可以重复的,所以是i-1)
            }
            HashSet<Integer> set = new HashSet<>();
            for (int j = i + 1; j < length; j++) {

                // 因为对第一个元素去重时，考虑了三元组内重复，所以如果i后面三个元素相同，跳过
                if (j > i + 2 && nums[j] == nums[j-1] && nums[j - 1] == nums[j-2]){
                    continue;// 对第二个元素去重
                }
                int temp = -(nums[i] + nums[j]);
                if (set.contains(temp)){
                    res.add(Arrays.asList(nums[i], nums[j], temp));
                    set.remove(temp);//对第三个元素去重
                }else {
                    set.add(nums[j]);
                }
            }
        }
        return res;
    }

    /**
     * 双指针法
     *
     * 如果nums[i] + nums[left] + nums[right] > 0 就说明 此时三数之和大了，
     * 因为数组是排序后了，所以right下标就应该向左移动，这样才能让三数之和小一些。
     *
     * 如果 nums[i] + nums[left] + nums[right] < 0 说明 此时 三数之和小了，
     * left 就向右移动，才能让三数之和大一些，直到left与right相遇为止。
     *
     * 注意去重和剪枝
     *
     */
    public static List<List<Integer>> solution2(int[] nums){
        Arrays.sort(nums);// 排序，方便去重
        List<List<Integer>> res = new ArrayList<>();

        int length = nums.length;

        // a = nums[i], b = nums[left], c = nums[right]
        for (int i = 0; i < length; i++) {
            if (nums[i] > 0){
                break;// a大于0,不可能组成符合的三元组
            }
            if (i > 0 && nums[i] == nums[i - 1]){
                continue;//对a去重(不能有重复的三元组，但三元组内的元素是可以重复的,所以是i-1)
            }
            int left = i + 1;
            int right = length - 1;
            while (left < right){
                int sum = nums[i] + nums[left] + nums[right];
                // 去重复逻辑如果放在这里，0，0，0 的情况，可能直接导致 right<=left 了，从而漏掉了 0,0,0 这种三元组
                /*
                while (right > left && nums[right] == nums[right - 1]) right--;
                while (right > left && nums[left] == nums[left + 1]) left++;
                */
                if (sum > 0){
                    right--;
                }else if (sum < 0){
                    left++;
                }else {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 去重逻辑应该放在找到一个三元组之后，对b 和 c去重
                    while (right > left && nums[left] == nums[left+1]) left++;
                    while (right > left && nums[right] == nums[right-1]) right--;
                    // 找到答案时，双指针同时收缩
                    right--;
                    left++;
                }
            }
        }
        return res;
    }

}

