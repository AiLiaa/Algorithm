package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 合并区间
 *
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 * 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 *
 * 示例 2:
 * 输入: intervals = [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 *
 */
public class Merge {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1) return intervals;

        List<int[]> res = new ArrayList<>();

        //更新最大右边界
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            //如果左边界大于最大右边界
            if (end < intervals[i][0]){
                //加入区间 并且更新start
                res.add(new int[]{start,end});
                start = intervals[i][0];
                end = intervals[i][1];
            }else {
                //更新最大右边界
                end = Math.max(end,intervals[i][1]);
            }
        }

        res.add(new int[]{start, end});
        return res.toArray(new int[res.size()][]);
    }
}
