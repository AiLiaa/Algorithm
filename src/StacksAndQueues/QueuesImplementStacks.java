package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 使用队列实现栈的下列操作：
 *
 * push(x) -- 元素 x 入栈
 * pop() -- 移除栈顶元素
 * top() -- 获取栈顶元素
 * empty() -- 返回栈是否为空
 * 注意:
 *
 * 你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合法的。
 * 你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
 * 你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。
 *
 * 一个队列实现栈
 *
 */

public class QueuesImplementStacks {

    Deque<Integer> queue;

    public QueuesImplementStacks() {

        queue = new ArrayDeque<>();
    }

    public void push(int x) {
        queue.push(x);

    }

    // 出栈时，把队列的元素pop再push,最后一个元素不push
    public int pop() {
        int size = queue.size() - 1;
        int temp;
        while (size-- > 0){
            temp = queue.pop();
            queue.push(temp);
        }
        return queue.pop();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {

        return queue.isEmpty();
    }
}
