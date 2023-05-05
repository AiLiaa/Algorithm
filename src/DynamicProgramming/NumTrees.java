package DynamicProgramming;

/**
 * 不同的二叉搜索树
 *
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 *
 * 递推公式：dp[i] += dp[j - 1] * dp[i - j]; ，
 * j-1 为j为头结点左子树节点数量，i-j 为以j为头结点右子树节点数量
 *
 */
public class NumTrees {
    public static int solution(int n) {

        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int r = solution(3);
        System.out.println(r);
    }
}
