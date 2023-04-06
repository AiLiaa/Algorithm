package Array.SpiralMatrix;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 *
 */

public class SpiralMatrix1 {

    public static List<Integer> solution(int[][] matrix){
        List<Integer> res = new ArrayList<>();
        int loop = 0;// 循环次数
        int m = matrix.length; // 行
        int n = matrix[0].length; // 列
        int startx = 0,starty = 0;// 循环的开始点
        int i,j;

        while (m < n ? loop++ < m / 2  : loop++ < n / 2 ){


            // 上边从左到右
            for (j = starty; j < n -loop; j++){
                res.add(matrix[startx][j]);
            }

            // 右边从上到下
            for (i = startx; i < m - loop; i++){
                res.add(matrix[i][j]);
            }

            // 下边从右到左
            for (; j >= loop; j--){
                res.add(matrix[i][j]);
            }

            // 右边从下到上
            for (; i >= loop; i--){
                res.add(matrix[i][j]);
            }

            startx++;
            starty++;
        }

        // 几圈循环完后有其中一小行或者列或者中间一个元素没有加入到list中
        if (res.size() < m * n){
            int t = m < n ? n - m + 1 : m - n + 1;
            for (int k = 0; k < t; k++) {
                if (n < m){ // 一小列
                    res.add(matrix[startx + k][starty]);
                }else if (m < n){ // 一小行
                    res.add(matrix[startx][starty + k]);
                }

            }
            // 中间一个元素
            if (n == m && m % 2 == 1){
                res.add(matrix[startx][starty]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] r = new int[3][3];
        r[0] = new int[]{1,2,3};
        r[1] = new int[]{8,9,4};
        r[2] = new int[]{7,6,5};;
        List<Integer> res = solution(r);
        System.out.println(res);
    }

}
