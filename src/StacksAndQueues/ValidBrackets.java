package StacksAndQueues;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 有效括号
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。

 * 示例 2:
 * 输入: "()[]{}"
 * 输出: true
 *
 * 示例 3:
 * 输入: "(]"
 * 输出: false
 *
 * 示例 4:
 * 输入: "([)]"
 * 输出: false
 *
 */
public class ValidBrackets {

    //HashMap和 Stack
    public static boolean solution1(String s){
        int length = s.length();
        Stack<Character> stack = new Stack<>();
        // 保存匹配规则
        HashMap<Character,Character> map = new HashMap<>();
        map.put(']','[');
        map.put(')','(');
        map.put('}','{');
        char[] chars = s.toCharArray();
        char pop = ' ';
        // 入栈匹配
        for (int i = 0; i < length; i++) {
            if (chars[i] == '(' || chars[i] == '[' || chars[i] == '{'){
                stack.push(chars[i]);
            }else {
                if (!stack.isEmpty()){
                    pop = stack.pop();
                    if (pop != map.get(chars[i])){
                        return false;// 匹配失败
                    }
                }else {
                    return false;// 多余的])}
                }
            }
        }
        //
        if (!stack.isEmpty()){
            return false;// // 多余的[({
        }
        return true;
    }

    //deque或者 栈
    public static boolean sulotion2(String s) {
        Deque<Character> deque = new LinkedList<>();
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            //碰到左括号，就把相应的右括号入栈
            if (ch == '(') {
                deque.push(')');
            }else if (ch == '{') {
                deque.push('}');
            }else if (ch == '[') {
                deque.push(']');
            } else if (deque.isEmpty() || deque.peek() != ch) {
                return false;
            }else {//如果是右括号 并且和栈顶元素匹配
                deque.pop();
            }
        }
        //最后判断栈中元素是否匹配
        return deque.isEmpty();
    }

    public static void main(String[] args) {
        boolean r = solution1("[[]()(){}");
        System.out.println(r);
    }
}
