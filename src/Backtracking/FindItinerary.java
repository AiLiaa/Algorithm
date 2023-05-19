package Backtracking;

import java.util.*;

/**
 * 重新安排行程
 *
 * 给定一个机票的字符串二维数组 [from, to]，子数组中的两个成员分别表示飞机出发和降落的机场地点，
 * 对该行程进行重新规划排序。所有这些机票都属于一个从 JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 开始。
 *
 * 提示：
 * 如果存在多种有效的行程，请你按字符自然排序返回最小的行程组合。
 * 例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前
 * 所有的机场都用三个大写字母表示（机场代码）。
 * 假定所有机票至少存在一种合理的行程。
 * 所有的机票必须都用一次 且 只能用一次。
 *
 * 示例 1：
 * 输入：[["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 * 输出：["JFK", "MUC", "LHR", "SFO", "SJC"]
 *
 * 示例 2：
 * 输入：[["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * 输出：["JFK","ATL","JFK","SFO","ATL","SFO"]
 * 解释：另一种有效的行程是 ["JFK","SFO","ATL","JFK","ATL","SFO"]。但是它自然排序更大更靠后。
 *
 * 1 <= tickets.length <= 300
 * tickets[i].length == 2
 * fromi.length == 3
 * toi.length == 3
 * fromi 和 toi 由大写英文字母组成
 * fromi != toi
 *
 */
public class FindItinerary {
    LinkedList<String> res = new LinkedList<>();
    LinkedList<String> path = new LinkedList<>();
    int[] used;

    public List<String> solution(List<List<String>> tickets) {
        int size = tickets.size();
        if (size == 1)return tickets.get(0);

        //排序
        Collections.sort(tickets, (a, b) -> a.get(1).compareTo(b.get(1)));
        used = new int[size];
        path.add("JFK");
        backtracking(tickets);
        return res;
    }

    //结果集中只需要一个，返回值是boolean
    public boolean backtracking(List<List<String>> tickets){
        //终止条件 把所有航班串联起来时，经过的机场数量是航班数加1
        if (path.size() == tickets.size() + 1){
            res = path;
            return true;
        }

        for (int i = 0; i < tickets.size(); i++) {

            if (used[i] == 1 || !tickets.get(i).get(0).equals(path.getLast())){
                continue;
            }
            path.add(tickets.get(i).get(1));
            used[i] = 1;
            if (backtracking(tickets)){
                return true;
            }
            path.removeLast();
            used[i] = 0;

        }
        return false;
    }
}
