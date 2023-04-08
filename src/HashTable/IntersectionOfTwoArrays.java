package HashTable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * 两个数组的交集
 *
 * 给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * 示例 2：
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 * 解释：[4,9] 也是可通过的
 *
 */

public class IntersectionOfTwoArrays {
    public static int[] solution(int[] num1, int[] num2){
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> ans = new HashSet<>();
        int len_num1 = num1.length;
        int len_num2 = num2.length;

        for (int i = 0; i < len_num1; i++) {
            set.add(num1[i]);
        }
        for (int i = 0; i < len_num2; i++) {
            if (set.contains(num2[i])){
                ans.add(num2[i]);
            }
        }
        int[] res = new int[ans.size()];
        // 迭代器遍历
//        Iterator<Integer> it = ans.iterator();
//        int i = 0;
//        while (it.hasNext()) {
//            res[i] = it.next();
//            i++;
//        }
        // for 循环遍历
        int i = 0;
        for (Integer integer : ans) {
            res[i] = integer;
            i++;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] ints1 = new int[]{1,2,3,4,5};
        int[] ints2 = new int[]{1,2,2};
        int[] res = solution(ints1, ints2);
        System.out.println(Arrays.toString(res));

    }
}
