package DynamicProgramming;

/**
 * 完全背包
 *
 * 有N件物品和一个最多能背重量为W的背包。第i件物品的重量是weight[i]，得到的价值是value[i] 。
 * 每件物品都有无限个（也就是可以放入背包多次），求解将哪些物品装入背包里物品价值总和最大。
 *
 * 完全背包和01背包问题唯一不同的地方就是，每种物品有无限件。
 * 01背包和完全背包唯一不同就是体现在遍历顺序上
 *
 * 01背包内嵌的循环是从大到小遍历，为了保证每个物品仅被添加一次。
 * 而完全背包的物品是可以添加多次的，所以要从小到大去遍历
 *
 * 对于纯完全背包问题，其for循环的先后循环是可以颠倒的
 * 因为dp[j] 是根据 下标j之前所对应的dp[j]计算出来的。 只要保证下标j之前的dp[j]都是经过计算的就可以了。
 */
public class Backpack_Complete {
    public static int testCompleteBackPack(int[] weight, int[] value, int bagSize){
        int[] dp = new int[bagSize + 1];

        for (int i = 0; i < weight.length; i++){ // 遍历物品
            for (int j = weight[i]; j <= bagSize; j++){ // 遍历背包容量
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }

        for (int maxValue : dp){
            System.out.print(maxValue + " ");
        }
        return dp[bagSize];
    }

    public static void main(String[] args) {
        int[] weight = {1,3,4};
        int[] value = {15,20,30};
        int bagSize = 4;
        int res = testCompleteBackPack(weight, value, bagSize);
        System.out.println();
        System.out.println(res);
    }
}
