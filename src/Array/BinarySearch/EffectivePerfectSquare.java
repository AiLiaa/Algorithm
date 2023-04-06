package Array.BinarySearch;

/**
 * 有效的完全平方数
 *
 * 给你一个正整数 num 。如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
 * 完全平方数 是一个可以写成某个整数的平方的整数。换句话说，它可以写成某个整数和自身的乘积。
 * 不能使用任何内置的库函数，如sqrt 。
 *
 * 二分查找
 *
 */

public class EffectivePerfectSquare {

    private static boolean solution(int num){

        int left = 0;
        int right = num;
        int middle = 0;

        while (left <= right){
            middle = left + ((right - left) >> 1);
            if ((long)(middle * middle) < num){
                left = middle + 1;
            }else if ((long)(middle * middle) > num){
                right = middle -1;
            }else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        boolean res = solution(16);
        System.out.println(res);
    }

}
