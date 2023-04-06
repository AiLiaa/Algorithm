package Array.DoublePointer;

import java.util.Arrays;

/**
 * 移动零元素到数组尾部，保持数组其他元素顺序不变
 *
 * 1.删除0；再在数组后面添加0
 * 2.交换，让leftPoint和rightPoint之间全是0
 *
 */


public class MoveZeros {

    public static void solution(int[] nums){

        int slowPointer = 0;
        int length = nums.length;
        for (int fastPointer = 0; fastPointer < length; fastPointer++) {
            if (nums[fastPointer] != 0){
                swap(nums,slowPointer,fastPointer);
                slowPointer++;
            }
        }
    }

    public static void swap(int[] nums, int slowPoint, int fastPoint){
        int temp = nums[slowPoint];
        nums[slowPoint] = nums[fastPoint];
        nums[fastPoint] = temp;

    }

    public static void main(String[] args) {
        int[] ints = {0,1,2,3,4,1,0,0,2,0};
        solution(ints);
        System.out.println(Arrays.toString(ints));
    }


}
