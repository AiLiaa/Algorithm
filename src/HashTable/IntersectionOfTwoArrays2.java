package HashTable;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 两个数组的交集2
 *
 * 给你两个整数数组nums1 和 nums2 ，请你以数组形式返回两数组的交集。返回结果中每个元素出现的次数，
 * 应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * 示例 2:
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 *
 * 进阶：
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？  双指针
 * 如果nums1的大小比nums2小，哪种方法更优？ 哈希表
 * 如果nums2的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？ 排序效率低
 */

public class IntersectionOfTwoArrays2 {

    // 哈希表
    public static int[] solution1(int[] nums1, int[] nums2) {
        // nums1 作为短数组，节省map 和 int[]空间
        if (nums1.length > nums2.length){
            return solution1(nums2, nums1);
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        int len_nums1 = nums1.length;
        int len_nums2 = nums2.length;

        for (int i = 0; i < len_nums1; i++) {
            map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
        }
        System.out.println(map);
        int[] ans = new int[len_nums1];
        int index = 0;
        for (int i = 0; i < len_nums2; i++) {
            int count = map.getOrDefault(nums2[i], 0);
            if (map.containsKey(nums2[i]) && count > 0){
                ans[index++] = nums2[i];
                count--;
            }
            if (count > 0){
                map.put(nums2[i], count);
            }else {
                map.remove(nums2[i]);
            }
        }
        return Arrays.copyOfRange(ans,0,index);
    }

    /**
     * 已排序数组,双指针
     */
    public static int[] solution2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int[] ans = new int[Math.min(nums1.length, nums2.length)];
        int index1 = 0,index2 = 0,index = 0;

        while (index1 < nums1.length && index2 < nums2.length){
            if (nums1[index1] < nums2[index2]){
                index1++;
            }else if (nums1[index1] > nums2[index2]){
                index2++;
            }else {
                ans[index] = nums1[index1];
                index++;
                index1++;
                index2++;
            }
        }
        return Arrays.copyOfRange(ans,0,index);
    }

    public static void main(String[] args) {
        int[] ints1 = new int[]{3,2,2,4,1};
        int[] ints2 = new int[]{1,8,2,9,1,4,2};
        int[] res = solution2(ints1, ints2);
        System.out.println(Arrays.toString(res));
    }
}
