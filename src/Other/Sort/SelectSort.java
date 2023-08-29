package Other.Sort;

import java.util.Arrays;

/**
 * 选择排序
 *
 * 一次次地从一个无序数组中拿出它当前最小的元素
 *
 * 最好/最坏情况的时间复杂度都是O(n2)
 */
public class SelectSort {

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; ++i) {
            int minIdx = i;
            // 在数组区间[i+1,j]中找出一个最小（比arr[i]还小的）的，记录其下标为minIdx
            for (int j = arr.length - 1; j > i; --j) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            // 当minIdx发生变动，证明数组区间[i+1,j]中有比arr[i]小的值，进行交换
            if (minIdx != i) {
                // 交换数组arr中下标为i和minIdx的值
                swap(arr, i, minIdx);
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
