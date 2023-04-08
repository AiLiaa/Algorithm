package HashTable;

import java.util.HashMap;

/**
 * 给定四个包含整数的数组列表 A,B,C,D,计算有多少个元组 (i,j,k,l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
 *
 * 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。
 * 所有整数的范围在 -2^28 到 2^28 - 1 之间，最终结果不会超过 2^31 - 1 。
 *
 * 例如:
 * 输入:
 * A = [ 1, 2]
 * B = [-2,-1]
 * C = [-1, 2]
 * D = [ 0, 2]
 * 输出:
 * 2
 * 解释:
 * 两个元组如下:
 * (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
 * (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 *
 * 哈希表
 * ab为一组,key存相加值，value存这样的值的次数
 * cd去找a+b = -（c+d） 的组合
 */

public class SumOfFourNumbers2 {

    public static int solution(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int temp;
        int count = 0;
        //统计两个数组中的元素之和，同时统计出现的次数，放入map
        for (int i : nums1) {
            for (int j : nums2) {
                temp = i + j;
                map.put(temp,map.getOrDefault(temp, 0)+1);
            }
        }
        //统计剩余的两个元素的和，在map中找是否存在相加为0的情况，同时记录次数
        for (int i : nums3) {
            for (int j : nums4) {
                temp = -(i + j);
                if (map.containsKey(temp)){
                    count += map.get(temp);
                }
            }
        }
        return count;
    }
}
