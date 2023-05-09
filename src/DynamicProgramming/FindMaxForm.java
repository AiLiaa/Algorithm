package DynamicProgramming;

/**
 * 零和一
 *
 * 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
 * 请你找出并返回 strs 的最大子集的长度，该子集中 最多 有 m 个 0 和 n 个 1 。
 * 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
 *
 * 示例 1：
 * 输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
 * 输出：4
 * 解释：最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4 。
 * 其他满足题意但较小的子集包括 {"0001","1"} 和 {"10","1","0"} 。{"111001"} 不满足题意，因为它含 4 个 1 ，大于 n 的值 3 。
 *
 * 1 <= strs.length <= 600
 * 1 <= strs[i].length <= 100
 * strs[i]仅由'0' 和 '1' 组成
 * 1 <= m, n <= 100
 *
 */
public class FindMaxForm {
    public int solution(String[] strs, int m, int n) {

        //dp[i][j]表示i个0和j个1时，最大子集的长度
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 0;

        for (int i = 0; i < strs.length; i++) {
            int count_0 = getCount_0(strs[i]);
            int count_1 = getCount_1(strs[i]);
            for (int j = m; j >= count_0; j--) {
                for (int k = n; k >= count_1; k--) {
                    dp[j][k] = Math.max(dp[j][k],dp[j - count_0][k - count_1] + 1);
                }
            }

        }
        return dp[m][n];
    }
    //字符串中1的数目
    public int getCount_1(String s){
        int length = s.length();
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == '1') count++;
        }
        return count;
    }
    //字符串中0的数目
    public int getCount_0(String s){
        int length = s.length();
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == '0') count++;
        }
        return count;
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"10", "0001", "111001", "1", "0"};
        FindMaxForm f = new FindMaxForm();
        int res = f.solution(strs, 5, 3);
        System.out.println(res);
    }
}
