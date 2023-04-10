package StacksAndQueues;

import java.util.Stack;

/**
 * 使用栈实现队列的下列操作：
 *
 * push(x) -- 将一个元素放入队列的尾部。
 * pop() -- 从队列首部移除元素。
 * peek() -- 返回队列首部的元素。
 * empty() -- 返回队列是否为空。
 *
 * 说明:
 * 你只能使用标准的栈操作 -- 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 * 假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）
 *
 * 用两个栈实现队列，一个入一个出
 */

public class StacksImplementQueues {

    public Stack<Integer> stackIn;
    public Stack<Integer> stackOut;

    public StacksImplementQueues() {

        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }

    // 进队
    public void push(int x) {
        stackIn.push(x);
    }

    //stackOut非空,把stackIn转移到stackOut准备出队
    public void dumpStackIn(){
        if (!stackOut.isEmpty()){
            return;
        }
        while (!stackIn.isEmpty()){
            stackOut.push(stackIn.pop());
        }
    }

    // 出队
    public int pop() {
        dumpStackIn();
        return stackOut.pop();
    }

    // 返回队头元素
    public int peek() {
        dumpStackIn();
        return stackOut.peek();
    }

    // 判断是否为空
    public boolean empty() {
        return stackOut.isEmpty() && stackIn.isEmpty();
    }
}
