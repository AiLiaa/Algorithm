package Other.Sort;

import java.util.Arrays;

/**
 * 希尔排序
 *
 * 在排序过程中需要按照分组
 * 增量就是在一个数组中跳着选数组元素，归为一组，再将每个组进行直接插入排序
 * 在所有组的直接插入排序完成后，将增量按照一定的规则缩小，再将上述操作进行一遍，直到增量最终小于1
 *
 * 希尔排序的时间复杂度取决于传入数组和增量策略的设置，时间复杂度范围在O(n*logn)~O(n2）
 *
 */
public class ShellSort {

    public static void sort(int[] arr) {
        int len = arr.length;
        int incr = len;
        while(incr > 1){
            // 每趟希尔排序，都让增量的值折半
            incr /= 2;
            for(int i = incr;i < len;++i){
                if(arr[i] < arr[i - incr]){
                    // 分组插入排序
                    // 当遍历时遇到相对有序，直接进行下一趟排序
                    for(int j = i;j >= incr;j -= incr){
                        if (arr[j]<arr[j - incr]){
                            swap(arr,j,j - incr);
                        }
                    }
                }
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 4, 2, 7, 1, 10, 6, 9};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
