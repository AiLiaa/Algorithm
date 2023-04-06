package Array.DoublePointer;

/**
 * 移除数组中的重复元素
 *
 * 给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 * 元素的相对顺序应该保持一致 。
 * 由于在某些语言中不能改变数组的长度，所以必须将结果放在数组nums的第一部分。更
 * 规范地说，如果在删除重复项之后有 k个元素，那么nums的前 k 个元素应该保存最终结果。
 * 将最终结果插入nums 的前 k个位置后返回 k 。
 * 不要使用额外的空间，你必须在原地修改输入数组 并在使用 O(1)额外空间的条件下完成。
 */

public class RemoveDuplicatesInArray {

    public static int solution(int[] nums){

        int slowPointer = 0;
        int length = nums.length;

        for (int fastPointer = 0; fastPointer + 1 < length; fastPointer++) {
            if (nums[fastPointer] != nums[fastPointer + 1]){
                nums[slowPointer++] = nums[fastPointer];
            }
        }
        return slowPointer + 1;
    }

    public static void main(String[] args) {
        int[] ints = {1,2,2,3,4,4,5,5,5,5,6,7,7,7,7,8};
        int res = solution(ints);
        System.out.println(res);
    }

}
