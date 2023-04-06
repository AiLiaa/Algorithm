package Array.SpiralMatrix;

import java.util.Arrays;

/**
 * 螺旋矩阵2
 *
 * 给定一个正整数 n，生成一个包含 1 到 n^2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 * 示例:
 * 输入: 3 输出: [ [ 1, 2, 3 ], [ 8, 9, 4 ], [ 7, 6, 5 ] ]
 *
 * 模拟顺时针画矩阵的过程:
 * 填充上行从左到右
 * 填充右列从上到下
 * 填充下行从右到左
 * 填充左列从下到上
 *
 * 左闭右开
 *
 */


public class SpiralMatrix2 {

    public static int[][] solution(int n){
        int loop = 0;  // 控制循环次数
        int[][] res = new int[n][n];
        int start = 0;  // 每次循环的开始点(start, start)
        int count = 1;  // 定义填充数字
        int i, j;

        while (loop++ < n/2){ // 循环次数,loop从1开始
            // 上边从左到右
            for (j = start; j < n - loop; j++) {
                res[start][j] = count++;
            }

            // 右边从上到下
            for (i = start; i < n - loop; i++) {
                res[i][j] = count++;
            }

            // 下边从右到左
            for (;j >= loop; j--){
                res[i][j] = count++;
            }

            // 左边从下到上
            for (;i >= loop; i--){
                res[i][j] = count++;
            }

            start++;

        }
        if (n % 2 == 1){
            res[start][start] = count;
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] r = solution(2);
        for (int[] date : r){

            for (int result : date){
                System.out.printf("%d\t",result);
            }

            System.out.println();

        }
    }

}
