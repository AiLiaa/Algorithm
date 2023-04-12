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
 *
 * hashmap heap实现
 *
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


    // 大顶堆
    public static int[] solution1(int[] nums, int k) {
        // 值和数目存放在map中
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        //在优先队列中存储二元组(num,cnt),cnt表示元素值num在数组中的出现次数
        //出现次数按从队头到队尾的顺序是从大到小排,出现次数最多的在队头(相当于大顶堆)
        PriorityQueue<int[]> pq = new PriorityQueue<>((pair1,pair2)->pair2[1] - pair1[1]);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.add(new int[]{entry.getKey(), entry.getValue()});
        }
        // 依次弹出k个元素,就是出现最多的k个
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll()[0];
        }
        return ans;
    }

    // 小顶堆
    public static int[] solution2(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (pq.size() < k){
                pq.add(new int[]{entry.getKey(), entry.getValue()});
            }else if (entry.getValue() > pq.peek()[1]){//当前元素出现次数大于小顶堆的根结点(这k个元素中出现次数最少的那个)
                pq.poll();//弹出队头(小顶堆的根结点),即把堆里出现次数最少的那个删除,留下的就是出现次数多的了
                pq.add(new int[]{entry.getKey(), entry.getValue()});
            }
        }

        int[] ans = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            ans[i] = pq.poll()[0];
        }
        return ans;
    }

        public static void main(String[] args) {
        int[] res = solution1(new int[]{1,1,1,2,2,3}, 2);
        System.out.println(Arrays.toString(res));
    }

}

