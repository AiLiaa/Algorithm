package Array.BinarySearch;

import java.util.Arrays;

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 *
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 示例 1：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 示例 2：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 *
 * 寻找target在数组里的左右边界，有如下三种情况：
 *
 * 情况一：target 在数组范围的右边或者左边，例如数组{3, 4, 5}，target为2或者数组{3, 4, 5},target为6，此时应该返回{-1, -1}
 * 情况二：target 在数组范围中，且数组中不存在target，例如数组{3,6,7},target为5，此时应该返回{-1, -1}
 * 情况三：target 在数组范围中，且数组中存在target，例如数组{3,6,7},target为6，此时应该返回{1, 1}
 *
 * 二分查找寻找左右边界
 *
 */

public class SearchFirstAndLast {

    public static int[] solution(int[] nums, int target){

        int left = 0;
        int right = nums.length - 1;
        int middle = 0;
        int rightBorder = -2,leftBorder = -2;

        while (left <= right){
            middle = left + ((right - left) >> 1);

            if (target <= nums[middle]){
                right = middle - 1;
                leftBorder = right;
            }else{
                left = middle + 1;
            }
        }

        left = 0;right = nums.length - 1;middle = 0;
        while (left <= right){
            middle = left + ((right - left) >> 1);

            if (target >= nums[middle]){
                left = middle + 1;
                rightBorder = left;
            }else{
                right = middle - 1;
            }
        }


        if (rightBorder == -2 || leftBorder == -2) return new int[] {-1, -1};

        if (rightBorder - leftBorder > 1) return new int[] {leftBorder + 1, rightBorder - 1};

        return new int[] {-1,-1};
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 3, 4, 5, 6, 7, 7, 7, 8, 10};
        int[] res = solution(nums, 3);

        System.out.println(Arrays.toString(res));
    }

}
