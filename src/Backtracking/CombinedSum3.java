package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 组合总和3
 *
 * 找出所有相加之和为n 的k个数的组合，且满足下列条件：
 *
 * 只使用数字1到9
 * 每个数字最多使用一次
 * 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
 *
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 * 解释:
 * 1 + 2 + 6 = 9
 * 1 + 3 + 5 = 9
 * 2 + 3 + 4 = 9
 * 没有其他符合的组合了。
 *
 */
public class CombinedSum3 {
    public List<List<Integer>> res = new ArrayList<>();//存放结果集
    public LinkedList<Integer> path = new LinkedList<>();//存放当结果

    public List<List<Integer>> solution(int k, int n) {
        backtracking(k,n,1,0);
        return res;
    }
    public void backtracking(int k,int n,int startIndex, int sum){
        // 剪枝
        if (sum > n){
            return;
        }

        // 终止条件
        if (path.size() == k){
            if (sum == n) res.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i <= 9 - (k - path.size()) + 1; i++) {
            // 处理该结点
            path.add(i);
            sum += i;
            // 递归
            backtracking(k,n,i+1, sum);
            // 回溯撤销
            path.removeLast();
            sum -= i;
        }
    }

    public static void main(String[] args) {
        CombinedSum3 combinedSum3 = new CombinedSum3();
        List<List<Integer>> r = combinedSum3.solution(3, 7);
        System.out.println(r.toString());
    }
}
