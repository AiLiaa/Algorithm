package MonotonicStack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 柱状图中最大的矩形
 *
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 * 输入：heights = [2,1,5,6,2,3]
 * 输出：10
 * 解释：最大的矩形为图中红色区域，面积为 10
 */
public class LargestRectangleArea {
    //暴力
    //对每一个柱子左右找比自己大的柱子，求面积
    public int largestRectangleArea1(int[] heights) {
        int sum = 0;

        for (int i = 0; i < heights.length; i++) {
            int left = i;
            int right = i;
            for (; left >= 0; left--) {
                if (heights[left] < heights[i]) break;
            }
            for (; right < heights.length; right++) {
                if (heights[right] < heights[i]) break;
            }
            int w = right - left - 1;
            int h = heights[i];
            sum = Math.max(sum,h*w);
        }
        return sum;
    }

    //双指针
    //记录每个柱子 左右第一个小于该柱子的下标
    public int largestRectangleArea2(int[] heights) {
        int sum = 0;
        int len = heights.length;
        int[] minLeft = new int[len];
        int[] minRight = new int[len];

        minLeft[0] = -1;//初始化防止while死循环
        // 记录每个柱子 左边第一个小于该柱子的下标
        for (int i = 1; i < len; i++) {
            int t = i - 1;
            //这里用t = minLeft[t]跳跃查找
            while (t >= 0 && heights[t] >= heights[i]) t = minLeft[t];
            minLeft[i] = t;
        }

        minRight[len - 1] = len;
        for (int i = len - 2; i >= 0; i--) {
            int t = i + 1;
            while (t < len && heights[t] >= heights[i]) t = minRight[t];
            minRight[i] = t;
        }

        for (int i = 0; i < len; i++) {
            int t = heights[i] * (minRight[i] - minLeft[i] - 1);
            sum = Math.max(t,sum);
        }
        return sum;
    }

    //单调栈
    //要找每个柱子左右两边第一个小于该柱子的柱子，所以从栈头（元素从栈头弹出）到栈底的顺序应该是从大到小的顺序
    public int largestRectangleArea3(int[] heights) {
        int sum = 0;

        // 数组扩容，在头和尾各加入一个元素0
        // 为什么要加元素0？
        // 如果数组本身是降序的，例如 [8,6,4,2]，在 8 入栈后，6开始与8进行比较，此时我们得到mid（8），right（6），但是得不到left。
        // 因为将8弹出之后，栈里没有元素了，那么为了避免空栈取值，直接跳过了计算结果的逻辑。
        // 之后又将6加入栈（此时8已经弹出了），然后 就是4与栈口元素6进行比较，周而复始，那么计算的最后结果sum就是0
        int [] newHeights = new int[heights.length + 2];
        newHeights[0] = 0;
        newHeights[newHeights.length - 1] = 0;
        for (int index = 0; index < heights.length; index++){
            newHeights[index + 1] = heights[index];
        }

        heights = newHeights;

        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);

        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > heights[stack.peek()]){
                stack.push(i);
            }else if (heights[i] == heights[stack.peek()]){
                stack.pop();
                stack.push(i);
            }else {
                while (!stack.isEmpty() && heights[i] < heights[stack.peek()]){
                    int mid = stack.pop();
                    if (!stack.isEmpty()){
                        int w = i - stack.peek() - 1;
                        int h = heights[mid];
                        sum = Math.max(sum,h * w);
                    }
                }
                stack.push(i);
            }
        }
        return sum;
    }

}
