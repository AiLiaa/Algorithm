package StacksAndQueues;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 滑动窗口最大值
 *
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。
 * 滑动窗口每次只向右移动一位。
 * 返回滑动窗口中的最大值。
 *
 * 进阶：
 * 你能在线性时间复杂度内解决此题吗？
 *
 * 示例 1：
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 *  使用单调队列的经典题目。
 *
 */
public class MaximumValueInSlidingWindow {

    public static int[] solution(int[] nums, int k) {
        if (nums.length == 1){
            return nums;
        }
        int res[] = new int[nums.length - k +1];
        int num = 0;
        
        MyQueue myQueue = new MyQueue();
        // 先把前k给数字放进去
        for (int i = 0; i < k; i++) {
            myQueue.add(nums[i]);
        }
        res[num++] = myQueue.peek();

        for (int i = k; i < nums.length; i++) {
            //滑动窗口移除最前面的元素，移除是判断该元素是否放入队列
            myQueue.poll(nums[i - k]);
            //滑动窗口加入最后面的元素
            myQueue.add(nums[i]);
            //记录对应的最大值
            res[num++] = myQueue.peek();
        }

        return res;
    }
}


// 自定义单调队列
//que.pop(滑动窗口中移除元素的数值)
// que.push(滑动窗口添加元素的数值)
// que.front()就返回要的最大值。
class MyQueue {

    Deque<Integer> deque;

    MyQueue(){
        deque = new LinkedList<>();
    }

    //弹出元素时，比较当前要弹出的数值是否等于队列出口的数值，如果相等则弹出
    //同时判断队列当前是否为空
    public void poll(int val){
        if(!deque.isEmpty() && val == deque.peek()){
            deque.poll();
        }
    }

    //添加元素时，如果要添加的元素大于入口处的元素，就将入口元素弹出
    //保证队列元素单调递减
    //比如此时队列元素3,1，2将要入队，比1大，所以1弹出，此时队列：3,2
    public void add(int val){
        while (!deque.isEmpty() && val > deque.peekLast()){
            deque.pollLast();
        }
        deque.add(val);
    }

    //队列队顶元素始终为最大值
    public int peek(){
        return deque.peek();
    }
}
