package MonotonicStack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 接雨水
 *
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 */
public class Trap {
    //暴力 双指针
    //每一列雨水的高度，取决于该列 左侧最高的柱子和右侧最高的柱子中 较矮的那个柱子的高度。
    public int trap1(int[] height) {
        int sum = 0;

        for (int i = 0; i < height.length; i++) {
            //第一个和最后一个柱子不接雨水
            if (i == 0 || i == height.length - 1) continue;

            int right = height[i];//记录右边最高柱子
            int left = height[i];//记录左边最高柱子

            for (int j = i + 1; j < height.length; j++) {
                if (height[j] > right) right = height[j];
            }
            for (int j = i - 1; j >= 0; j--) {
                if (height[j] > left) left = height[j];
            }

            int h = Math.min(left, right) - height[i];
            if (h > 0) sum += h;
        }
        return sum;
    }

    //双指针优化
    //动态规划
    //把每一个位置的左边最高高度记录在一个数组上（maxLeft），右边最高高度记录在一个数组上（maxRight），避免重复计算。
    //即从左向右遍历：maxLeft[i] = max(height[i], maxLeft[i - 1]);
    //从右向左遍历：maxRight[i] = max(height[i], maxRight[i + 1]);
    public int trap2(int[] height) {
        int sum = 0;
        int len = height.length;
        int[] maxLeft = new int[len];
        int[] maxRight = new int[len];

        maxLeft[0] = height[0];
        for (int i = 1; i < len; i++) {
            maxLeft[i] = Math.max(height[i], maxLeft[i - 1]);
        }

        maxRight[len - 1] = height[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            maxRight[i] = Math.max(height[i], maxRight[i + 1]);
        }

        for (int i = 1; i < len - 1; i++) {
            int h = Math.min(maxLeft[i], maxRight[i]) - height[i];
            if (h > 0) sum += h;
        }

        return sum;
    }

    //单调栈
    //按照行方向来计算雨水
    //从栈头（元素从栈头弹出）到栈底的顺序是从小到大的顺序。
    //遇到相同的元素，更新栈内下标，就是将栈里元素（旧下标）弹出，将新元素（新下标）加入栈中。
    public int trap3(int[] height) {
        if (height.length <= 2) return 0;
        int sum = 0;

        //存放下标
        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);

        for (int i = 1; i < height.length; i++) {
            if (height[i] < height[stack.peek()]){
                stack.push(i);
            }else if (height[i] == height[stack.peek()]){
                stack.pop();
                stack.push(i);
            }else {
                while (!stack.isEmpty() && height[i] > height[stack.peek()]){
                    //取栈顶元素，将栈顶元素弹出，这个就是凹槽的底部，也就是中间位置
                    int mid = stack.pop();
                    if (!stack.isEmpty()){
                        //雨水高度是 min(凹槽左边高度, 凹槽右边高度) - 凹槽底部高度
                        int h = Math.min(height[i],height[stack.peek()]) - height[mid];
                        //雨水的宽度是 凹槽右边的下标 - 凹槽左边的下标 - 1（因为只求中间宽度）
                        int w = i - stack.peek() - 1;
                        sum += h * w;
                    }
                }
                stack.push(i);
            }
        }
        return sum;
    }
}