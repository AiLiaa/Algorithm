package StacksAndQueues;

import java.util.Stack;

/**
 * 逆波兰表达式求值
 *
 * 根据 逆波兰表示法，求表达式的值。
 * 有效的运算符包括 + ,  - ,  * ,  / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * 说明：
 * 整数除法只保留整数部分。 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 *
 * 示例 1：
 * 输入: ["2", "1", "+", "3", " * "]
 * 输出: 9
 * 解释: 该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
 *
 * 示例 2：
 * 输入: ["4", "13", "5", "/", "+"]
 * 输出: 6
 * 解释: 该算式转化为常见的中缀算术表达式为：(4 + (13 / 5)) = 6
 *
 * 逆波兰表达式：是一种后缀表达式，所谓后缀就是指运算符写在后面。
 * 平常使用的算式则是一种中缀表达式，如 ( 1 + 2 ) * ( 3 + 4 ) 。
 * 该算式的逆波兰表达式写法为 ( ( 1 2 + ) ( 3 4 + ) * ) 。
 * 逆波兰表达式主要有以下两个优点：
 * 去掉括号后表达式无歧义，上式即便写成 1 2 + 3 4 + * 也可以依据次序计算出正确结果。
 * 适合用栈操作运算：遇到数字则入栈；遇到运算符则取出栈顶两个数字进行计算，并将结果压入栈中。
 *
 */
public class ReversePolishNotation {

    public static int solution(String[] tokens){

        int length = tokens.length;
        if (length == 1){
            return Integer.parseInt(tokens[0]);
        }

        Stack<Integer> stack = new Stack<>();
        int num1,num2,res = 0;

        for (int i = 0; i < length; i++) {
            String token = tokens[i];
            // 数字进栈
            if (!(token.equals("+") || token.equals("-") ||
                    token.equals("*") || token.equals("/"))){
                stack.push(Integer.parseInt(token));
            }else {
                num1 = stack.pop();
                num2 = stack.pop();
                switch (token){
                    case "+":
                        res = num1 + num2;
                        break;
                    case "-":
                        res = num2 - num1;
                        break;
                    case "*":
                        res = num2 * num1;
                        break;
                    case "/":
                        res = num2 / num1;
                        break;
                }
                stack.push(res);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] strings = new String[]{"2", "1", "+", "3", "*"};
        int res = solution(strings);
        System.out.println(res);
    }
}
