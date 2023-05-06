package DynamicProgramming;

/**
 * 01背包
 *
 * 有n件物品和一个最多能背重量为w 的背包。
 * 第i件物品的重量是weight[i]，得到的价值是value[i] 。
 * 每件物品只能用一次，求解将哪些物品装入背包里物品价值总和最大。
 *
 *
 */
public class Backpack_01 {
    /**
     * 二维 dp[][]
     *
     * dp[i][j] 表示从下标为[0-i]的物品里任意取，放进容量为j的背包，价值总和最大是多少。
     * 递归公式： dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
     * 先遍历 物品还是先遍历背包重量呢？都可以 但是先遍历物品更好理解。
     */
    public static int testWeightBagProblem1(int[] weight, int[] value, int bagSize){
        int dp[][] = new int[weight.length][bagSize + 1];

        // 初始化
        for (int j = weight[0]; j <= bagSize; j++) {
            dp[0][j] = value[0];
        }

        for (int i = 1; i < weight.length; i++) {
            for (int j = 1; j <= bagSize; j++) {
                if (j < weight[i]){
                    /**
                     * 当前背包的容量都没有当前物品i大的时候，是不放物品i的
                     * 那么前i-1个物品能放下的最大价值就是当前情况的最大价值
                     */
                    dp[i][j] = dp[i - 1][j];
                }else {
                    /**
                     * 当前背包的容量可以放下物品i
                     * 那么此时分两种情况：
                     *    1、不放物品i
                     *    2、放物品i
                     * 比较这两种情况下，哪种背包中物品的最大价值最大
                     */
                    dp[i][j] = Math.max(dp[i - 1][j],dp[i - 1][j - weight[i]] + value[i]);
                }
            }
        }
        // 打印dp数组
        for (int i = 0; i < weight.length; i++) {
            for (int j = 0; j <= bagSize; j++) {
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println("\n");
        }
        return dp[weight.length - 1][bagSize];
    }

    /**
     * 一维 dp[]
     *
     * 在使用二维数组的时候，递推公式：dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
     * 其实可以发现如果把dp[i - 1]那一层拷贝到dp[i]上，表达式完全可以是：dp[i][j] = max(dp[i][j], dp[i][j - weight[i]] + value[i]);
     * 与其把dp[i - 1]这一层拷贝到dp[i]上，不如只用一个一维数组了，只用dp[j]（一维数组，也可以理解是一个滚动数组）。
     *
     * dp[j]表示：容量为j的背包，所背的物品价值可以最大为dp[j]。
     * 递归公式：dp[j] = max(dp[j], dp[j - weight[i]] + value[i]);
     * 如果题目给的价值都是正整数那么非0下标都初始化为0。
     *
     * 二维dp遍历的时候，背包容量是从小到大，而一维dp遍历的时候，背包是从大到小。
     * 倒序遍历背包容量j是为了保证物品i只被放入一次！
     * 倒序遍历的原因，本质上还是一个对二维数组的遍历，并且右下角的值依赖上一层左上角的值
     *
     * 必须先遍历物品嵌套遍历背包容量
     * 因为背包容量j一定是要倒序遍历，如果遍历背包容量放在上一层，那么每个dp[j]就只会放入一个物品，即：背包里只放入了一个物品。
     */
    public static int testWeightBagProblem2(int[] weight, int[] value, int bagSize){

        int[] dp = new int[bagSize + 1];

        for (int i = 0; i < weight.length; i++) {
            for (int j = bagSize; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j],dp[j - weight[i]] + value[i]);
            }
        }
        //打印dp数组
        for (int j = 0; j <= bagSize; j++){
            System.out.print(dp[j] + " ");
        }
        return dp[bagSize];
    }

    public static void main(String[] args) {
        int[] weight = {1,3,4};
        int[] value = {15,20,30};
        int bagSize = 4;
        int res = testWeightBagProblem2(weight, value, bagSize);
        System.out.println();
        System.out.println(res);
    }
}
