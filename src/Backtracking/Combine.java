package Backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 组合
 *
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * 你可以按 任何顺序 返回答案。
 * 示例: 输入: n = 4, k = 2 输出: [ [2,4], [3,4], [2,3], [1,2], [1,3], [1,4], ]
 *
 * 递归来做层叠嵌套（可以理解是开k层for循环），每一次的递归中嵌套一个for循环，那么递归就可以用于解决多层嵌套循环的问题了。
 *
 */
public class Combine {
    public List<List<Integer>> res = new ArrayList<>();//存放结果集
    public LinkedList<Integer> path = new LinkedList<>();//存放当结果

    public List<List<Integer>> solution(int n,int k){
        backtracking(n,k,1);
        return res;
    }

    public void backtracking(int n,int k,int startIndex){
        // 终止条件
        if (path.size() == k){
            res.add(new ArrayList<>(path));
            return;
        }

        //(int i = startIndex; i <= n; i++)可优化 剪枝，
        // 比如n = 2 k = 2时，第一层取n = 2时一定构不成k=2个数的组合了
        // 优化过程如下：
        //已经选择的元素个数：path.size();
        //还需要的元素个数为: k - path.size();
        //在集合n中至多要从该起始位置 : n - (k - path.size()) + 1，开始遍历
        //为什么有个+1呢，因为包括起始位置，我们要是一个左闭的集合。
        //举个例子，n = 4，k = 3， 目前已经选取的元素为0（path.size为0），n - (k - 0) + 1 即 4 - ( 3 - 0) + 1 = 2。
        //从2开始搜索都是合理的，可以是组合[2, 3, 4]。
        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) { // 控制树的横向遍历
            path.add(i);    // 处理节点
            backtracking(n,k,i+1);  // 递归：控制树的纵向遍历，注意下一层搜索要从i+1开始
            path.removeLast();  // 回溯，撤销处理的节点
        }
    }
}
