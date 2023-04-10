package StacksAndQueues;

import java.util.*;

/**
 * 前 K 个高频元素
 *
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 * 示例 1:
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 *
 * 示例 2:
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *
 * 提示：
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 $O(n \log n)$ , n 是数组的大小。
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
 * 你可以按任意顺序返回答案。
 */
public class TopKHighFrequencyElements {

//    public static int[] solution(int[] nums, int k) {
//        HashMap<Integer,Integer> map = new HashMap<>();//key数值,value次数
//        int length = nums.length;
//        if (length==2 && nums[0] !=nums[1] ){
//            return nums;
//        }
//        int[] res = new int[k];
//
//        for (int i = 0; i < length; i++) {
//            map.put(nums[i],map.getOrDefault(nums[i],0) + 1);
//        }
//
//        int size = map.values().size();
//        int[] count = new int[size];
//        int num = 0;
//        for (int i : map.values()) {
//            count[num++] = i;
//        }
//        Arrays.sort(count);
//        int[] ints = Arrays.copyOfRange(count, count.length - k, count.length);
//        num = 0;
//
//        for (int i : ints) {
//            res[num++] = getKey(map,i);
//        }
//        return res;
//    }
//    // 根据value获取key
//    public static int getKey(Map map, Object value){
//        for(Object key: map.keySet()){
//            if(map.get(key).equals(value)){
//                return (int) key;
//            }
//        }
//        return 0;
//    }

    public static int[] solution(int[] nums, int k) {
        return nums;
    }

        public static void main(String[] args) {
        int[] res = solution(new int[]{1,1,1,2,2,3}, 2);
        System.out.println(Arrays.toString(res));
    }

}

