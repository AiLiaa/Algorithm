package DynamicProgramming;

/**
 * 不相交的线
 *
 * 我们在两条独立的水平线上按给定的顺序写下 A 和 B 中的整数。
 * 现在，我们可以绘制一些连接两个数字 A[i] 和 B[j] 的直线，只要 A[i] == B[j]，
 * 且我们绘制的直线不与任何其他连线（非水平线）相交。
 *
 * 以这种方法绘制线条，并返回我们可以绘制的最大连线数。
 *
 * 输入：nums1 = [1,4,2], nums2 = [1,2,4]
 * 输出：2
 * 解释：可以画出两条不交叉的线 但无法画出第三条不相交的直线，因为从 nums1[1]=4 到 nums2[2]=4 的直线
 * 将与从 nums1[2]=2 到 nums2[1]=2 的直线相交。
 *
 * 提示：
 * 1 <= nums1.length, nums2.length <= 500
 * 1 <= nums1[i], nums2[j] <= 2000
 *
 */
public class MaxUncrossedLines {

    public int maxUncrossedLines(int[] nums1, int[] nums2) {

        //dp[i][j]表示nums1[0,i - 1]和nums2[0,j - 1]的最大连线数
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];

        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i - 1] == nums2[j - 1]){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j],dp[i][j - 1]);
                }
            }
        }

        return dp[nums1.length][nums2.length];
    }
}
