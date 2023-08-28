package Other.Sort;

/**
 * 冒泡排序
 */

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 6, 4};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr)); // [3, 4, 5, 6, 8]
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped = true;
        for (int i = 0; i < n - 1 && swapped; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // 交换相邻元素
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
        }
    }
}
