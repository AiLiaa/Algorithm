package Greedy;

/**
 * 加油站
 *
 * 在一条环路上有 n个加油站，其中第 i个加油站有汽油gas[i]升。
 *
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1个加油站需要消耗汽油cost[i]升。
 * 你从其中的一个加油站出发，开始时油箱为空。
 *
 * 给定两个整数数组 gas 和 cost ，如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。
 * 如果存在解，则 保证 它是 唯一 的。
 *
 * 示例1:
 * 输入: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
 * 输出: 3
 * 解释:
 * 从 3 号加油站(索引为 3 处)出发，可获得 4 升汽油。此时油箱有 = 0 + 4 = 4 升汽油
 * 开往 4 号加油站，此时油箱有 4 - 1 + 5 = 8 升汽油
 * 开往 0 号加油站，此时油箱有 8 - 2 + 1 = 7 升汽油
 * 开往 1 号加油站，此时油箱有 7 - 3 + 2 = 6 升汽油
 * 开往 2 号加油站，此时油箱有 6 - 4 + 3 = 5 升汽油
 * 开往 3 号加油站，你需要消耗 5 升汽油，正好足够你返回到 3 号加油站。
 * 因此，3 可为起始索引。
 *
 * 示例 2:
 * 输入: gas = [2,3,4], cost = [3,4,3]
 * 输出: -1
 * 解释:
 * 你不能从 0 号或 1 号加油站出发，因为没有足够的汽油可以让你行驶到下一个加油站。
 * 我们从 2 号加油站出发，可以获得 4 升汽油。 此时油箱有 = 0 + 4 = 4 升汽油
 * 开往 0 号加油站，此时油箱有 4 - 3 + 2 = 3 升汽油
 * 开往 1 号加油站，此时油箱有 3 - 3 + 3 = 3 升汽油
 * 你无法返回 2 号加油站，因为返程需要消耗 4 升汽油，但是你的油箱只有 3 升汽油。
 * 因此，无论怎样，你都不可能绕环路行驶一周。
 *
 * 提示:
 * gas.length == n
 * cost.length == n
 * 1 <= n <= 105
 * 0 <= gas[i], cost[i] <= 104
 *
 */
public class CanCompleteCircuit {

    /**
     * 直接从全局进行贪心选择，情况如下：
     *
     * 情况一：如果gas的总和小于cost总和，那么无论从哪里出发，一定是跑不了一圈的
     * 情况二：rest[i] = gas[i]-cost[i]为一天剩下的油，i从0开始计算累加到最后一站，
     * 如果累加没有出现负数，说明从0出发，油就没有断过，那么0就是起点。
     * 情况三：如果累加的最小值是负数，汽车就要从非0节点出发，从后向前，看哪个节点能把这个负数填平，
     * 能把这个负数填平的节点就是出发节点。
     */
    public int solution1(int[] gas, int[] cost) {
        int sum = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < gas.length; i++) {
            int temp = gas[i] - cost[i];
            sum += temp;
            if (sum < min){
                min = sum;
            }
        }
        if (sum < 0) return -1;//情况1
        if (min >= 0) return 0;//情况2

        //情况3
        for (int i = gas.length - 1; i > 0; i--) {
            int temp = gas[i] - cost[i];
            min += temp;
            if (min >= 0) return i;
        }
        return -1;
    }

    /**
     * 局部最优：当前累加rest[i]的和curSum一旦小于0，起始位置至少要是i+1，因为从i之前开始一定不行。
     * 全局最优：找到可以跑一圈的起始位置。
     */
    public int solution2(int[] gas, int[] cost) {

        int cruSum = 0;
        int totalSum = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            cruSum += gas[i] - cost[i];
            totalSum += gas[i] - cost[i];

            if (cruSum < 0){
                cruSum = 0;
                start = i + 1;
            }
        }
        if (totalSum < 0) return -1;
        return start;
    }
}
