package Array.DoublePointer;

import java.util.Arrays;

/**
 * 有序数组平方
 *
 *给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 *
 * 示例 1： 输入：nums = [-4,-1,0,3,10] 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]，排序后，数组变为 [0,1,9,16,100]
 *
 * 示例 2： 输入：nums = [-7,-3,2,3,11] 输出：[4,9,9,49,121]
 *
 *
 * 双指针 left right
 * left指向起始位置，right指向终止位置。
 *
 * 定义一个新数组result，和A数组一样的大小，让k指向result数组终止位置。
 * 如果A[i] * A[i] < A[j] * A[j] 那么result[k--] = A[j] * A[j]; 。
 * 如果A[i] * A[i] >= A[j] * A[j] 那么result[k--] = A[i] * A[i]; 。
 *
 */

public class OrderedArraySquare {

    public static int[] solution(int[] nums){

        int left = 0;
        int right = nums.length - 1;

        int[] res = new int[nums.length];
        int index = nums.length - 1;

        while (left <= right){
            if (nums[left] * nums[left] < nums[right] * nums[right]){
                res[index] = nums[right] * nums[right];
                right--;
            }else {
                res[index] = nums[left] * nums[left];
                left++;
            }
            index--;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] ints = {-5,-2,0,2,3,4};
        int[] res = solution(ints);
        System.out.println(Arrays.toString(res));
    }

}
