package Array.DoublePointer;

/**
 * 移除数组中指定元素
 *
 * 返回移除后的数组长度
 */

public class RemoveArrayElements {

    public static int solution(int[] nums, int x){

        int slowPointer = 0;
        int length = nums.length;

        for (int fastPointer = 0; fastPointer < length; fastPointer++){
            if (nums[fastPointer] != x){
                nums[slowPointer++] = nums[fastPointer];
            }
        }
        return slowPointer;
    }

    public static void main(String[] args) {
        int[] ints = {1,1,2,3,4,5,6,};
        int res = solution(ints, 1);
        System.out.println(res);
    }

}
