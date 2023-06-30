package DynamicProgramming;

/**
 * 最长重复子数组
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 *
 * 示例：
 * 输入：
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 *
 * 输出：3
 * 解释：长度最长的公共子数组是 [3, 2, 1] 。
 *
 * 提示：
 * 1 <= len(A), len(B) <= 1000
 * 0 <= A[i], B[i] < 100
 *
 */
public class FindLength {
    public int findLength(int[] nums1, int[] nums2) {

        //dp[i][j] ：以下标i - 1为结尾的A，和以下标j - 1为结尾的B，最长重复子数组长度为dp[i][j]。
        //方便初始化，dp[i][0]和dp[0][j]初始为全0
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];

        int result = 0;
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i - 1] == nums2[j - 1]){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                result = Math.max(dp[i][j],result);
            }
        }
        return result;

    }
}
