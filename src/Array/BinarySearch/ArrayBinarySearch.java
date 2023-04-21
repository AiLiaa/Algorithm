package Array.BinarySearch;

/**
 * 有序不重复数组二分查找
 *
 *
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，
 * 写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 *
 * 提示：
 *
 * 你可以假设 nums 中的所有元素是不重复的。
 * n 将在 [1, 10000]之间。
 * nums 的每个元素都将在 [-9999, 9999]之间。
 *
 * 思路：
 *
 * 这道题目的前提是数组为有序数组，同时题目还强调数组中无重复元素，
 * 因为一旦有重复元素，使用二分查找法返回的元素下标可能不是唯一的，
 * 这些都是使用二分法的前提条件
 *
 *
 * 二分查找涉及的很多的边界条件，逻辑比较简单，但就是写不好。
 * 例如到底是 while(left < right) 还是 while(left <= right)，
 * 到底是right = middle呢，还是要right = middle - 1
 *
 * 定义target在[left, right]区间，有如下两点：
 *
 * while (left <= right) 要使用 <= ，因为left == right是有意义的，所以使用 <=
 * if (nums[middle] > target) right 要赋值为 middle - 1，因为当前这个nums[middle]一定不是target，
 * 那么接下来要查找的右区间结束下标位置就是 middle - 1
 *
 */


public class ArrayBinarySearch {

    /**
     * 定义target在[left, right]区间
     */
    public static int solution(int[] nums, int target){

        int left = 0;
        int right = nums.length - 1;

        if (target < nums[left] || target > nums[right]){
            return -1;
        }

        int middle = 0;

        while (left <= right){

            middle = left + ((right - left) >> 1);

            if (target < nums[middle]){
                right = middle - 1;
            }else if (target > nums[middle]){
                left = middle + 1;
            }else {
                return middle;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        int[] ints = {-1,0,3,4,5,6,7,9,11,23,54,67};
        int res = solution(ints, 54);
        System.out.println(res);
    }

}
