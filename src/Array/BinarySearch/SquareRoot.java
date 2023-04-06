package Array.BinarySearch;

/**
 * x的平方根
 *
 * 给你一个非负整数 x ，计算并返回x的算术平方根，由于返回类型是整数，结果只保留整数部分，小数部分将被舍去，
 * 注意：不允许使用任何内置指数函数和算符，例如 pow (x，0.5）或者 x **0.5。
 *
 * 二分查找，以x为右边界，判断m的平方是否<=x
 *
 */


public class SquareRoot {

    public static int solution(int x){

        int left = 0;
        int right = x;
        int middle = 0;
        int ans = -1;

        while (left <= right){
            middle = left + ((right - left) >> 1);

            if ((long)(middle * middle) <= x){
                left = middle + 1;
                ans = middle;
            }else {
                right = middle - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int r = solution(145);
        System.out.println(r);
    }

}
