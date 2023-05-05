package Greedy;

/**
 * 跳跃游戏II
 *
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 示例:
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 * 从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 *
 * 说明: 假设你总是可以到达数组的最后一个位置。
 */
public class CanJump2 {

    public static int solution(int[] nums) {
        if (nums.length == 1) return 0;

        int cover = 0;//能跳跃的最大范围
        int count = 0;//跳跃次数
        int temp = 0;
        for (int i = 0; i <= cover; i++) {
            temp = (nums[i] + i) > temp ? (nums[i] + i) : temp;
            // 在这次的覆盖范围中，跳跃到 跳跃后能使cover最大的地方
            if (i == cover){
                cover = temp;
                count++;
                if (cover >= nums.length - 1) break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int r = solution(new int[]{2, 3, 1, 1, 4});
        System.out.println(r);
    }
}
