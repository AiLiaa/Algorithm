package Array.SlidingWindow;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。
 * 如果不存在符合条件的子数组，返回 0。
 *
 * 示例：
 *
 * 输入：s = 7, nums = [2,3,1,2,4,3] 输出：2 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 *
 * 提示：
 *
 * 1 <= target <= 10^9
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^5
 *
 * 滑动窗口，就是不断的调节子序列的起始位置和终止位置，从而得出我们要想的结果。
 *
 * 窗口内是什么？
 * 如何移动窗口的起始位置？
 * 如何移动窗口的结束位置？
 *
 * 窗口就是 满足其和 ≥ s 的长度最小的 连续 子数组。
 * 窗口的起始位置如何移动：如果当前窗口的值大于s了，窗口就要向前移动了（也就是该缩小了）。
 * 窗口的结束位置如何移动：窗口的结束位置就是遍历数组的指针，也就是for循环里的索引。
 *
 * 滑动窗口算是双指针的一种
 */

public class MinimumLengthSubarray {

    public static int solution(int[] nums, int s){

        int res = Integer.MAX_VALUE;
        int i = 0; // 起始
        int sum = 0; // 窗口内的和
        int minLength = 0;

        int len = nums.length;

        for (int j = 0; j < len; j++) {
            sum += nums[j];
            while (sum >= s){
                minLength = j - i + 1;
                res = res < minLength ? res : minLength;
                sum -= nums[i++]; // 调整起始位置
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }

    public static void main(String[] args) {
        int[] ints = {1,3,4,5,3,1,4,5,3,2};
        int r = solution(ints, 17);
        System.out.println(r);
    }

}
