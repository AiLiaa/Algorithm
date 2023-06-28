package MonotonicStack;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 下一个更大元素 I
 *
 * 给你两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。
 * 请你找出 nums1 中每个元素在 nums2 中的下一个比其大的值。
 * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。
 *
 * 示例 1:
 * 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * 输出: [-1,3,-1]
 * 解释:
 * 对于 num1 中的数字 4 ，你无法在第二个数组中找到下一个更大的数字，因此输出 -1 。
 * 对于 num1 中的数字 1 ，第二个数组中数字1右边的下一个较大数字是 3 。
 * 对于 num1 中的数字 2 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
 *
 * 示例 2:
 * 输入: nums1 = [2,4], nums2 = [1,2,3,4].
 * 输出: [3,-1]
 * 解释:
 * 对于 num1 中的数字 2 ，第二个数组中的下一个较大数字是 3 。
 * 对于 num1 中的数字 4 ，第二个数组中没有下一个更大的数字，因此输出-1 。
 *
 * 提示：
 * 1 <= nums1.length <= nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 10^4
 * nums1和nums2中所有整数 互不相同
 * nums1 中的所有整数同样出现在 nums2 中
 *
 */
public class NextGreaterElement {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        //结果集
        int[] result = new int[nums1.length];

        //key: num1值
        //value: num1的值对应的下标
        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < nums1.length; i++) {
            result[i] = -1;
            map.put(nums1[i],i);
        }

        //存放数组下标
        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);

        for (int i = 1; i < nums2.length; i++) {
            if (nums2[i] <= nums2[stack.peek()]){
                stack.push(i);
            }else {
                while (!stack.isEmpty() && nums2[i] > nums2[stack.peek()]){
                    //处理栈顶元素
                    if (map.containsKey(nums2[stack.peek()])) { // 看map里是否存在这个元素
                        Integer index = map.get(nums2[stack.peek()]); // 根据map找到nums2[stack.peek()]在nums1中的下标
                        result[index] = nums2[i];
                    }
                    stack.pop();
                }
                stack.push(i);
            }
        }

        return result;
    }
}
