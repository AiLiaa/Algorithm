package Array.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 水果成篮
 *
 * 你正在探访一家农场，农场从左到右种植了一排果树。这些树用一个整数数组 fruits 表示，其中 fruits[i] 是第 i 棵树上的水果 种类 。
 *
 * 你想要尽可能多地收集水果。然而，农场的主人设定了一些严格的规矩，你必须按照要求采摘水果：
 *
 * 你只有 两个 篮子，并且每个篮子只能装 单一类型 的水果。每个篮子能够装的水果总量没有限制。
 * 你可以选择任意一棵树开始采摘，你必须从 每棵 树（包括开始采摘的树）上 恰好摘一个水果 。
 * 采摘的水果应当符合篮子中的水果类型。每采摘一次，你将会向右移动到下一棵树，并继续采摘。
 * 一旦你走到某棵树前，但水果不符合篮子的水果类型，那么就必须停止采摘。
 * 给你一个整数数组 fruits ，返回你可以收集的水果的 最大 数目。
 *
 * 示例 ：
 *
 * 输入：fruits = [1,2,1]
 * 输出：3
 * 解释：可以采摘全部 3 棵树。
 *
 * 示例 ：
 *
 * 输入：fruits = [3,3,3,1,2,1,1,2,3,3,4]
 * 输出：5
 * 解释：可以采摘 [1,2,1,1,2] 这五棵树。
 *
 * 滑动窗口 + Hash表
 * hash表的key存储fruits[j] value存储窗口中fruits[j]的数目
 * 当map.size()>2 时，移动i 并且判断value是否为0,等于0则移除该fruit，继续移动j存储新的fruit
 *
 */

public class MostFruitTrees {

    public static int solution(int[] fruits){
        int i = 0; // 窗口起始
        int res = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        int length = fruits.length;

        for (int j = 0; j < length; j++) {
            map.put(fruits[j], map.getOrDefault(fruits[j], 0) + 1);
            while (map.size() > 2){
                map.put(fruits[i], map.get(fruits[i]) - 1);
                if (map.get(fruits[i]) == 0){
                    map.remove(fruits[i]);
                }
                i++;
            }
            res = Math.max(res, j - i + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] ints = {1,1,2,3,4,4,4,4,5,6,6,6};
        int r = solution(ints);
        System.out.println(r);
    }

}
