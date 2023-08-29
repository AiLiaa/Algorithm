package Other.Sort;

import java.util.Arrays;

/**
 * 归并排序
 *
 * 分治的思想，其将一个数组一分为二，二分为四，直到不能再分
 *
 * 并排序总共需要走logn次O(n)的操作，的时间复杂度为 O(n*logn)
 *
 */
public class MergeSort {

    //拆分
    private static void sort(int[] arr, int L, int R) {
        if (L < R) {
            int mid = L + ((R - L) >> 1);
            sort(arr, L, mid);
            sort(arr, mid + 1, R);
            merge(arr, L, mid, R);
        }
    }

    //合并
    private static void merge(int[] arr, int L, int mid, int R) {
        int[] tmpArr = new int[R - L + 1];
        int idx = 0;
        int i = L, j = mid + 1;
        // 同时遍历arr数组中[L, mid]和[mid+1, R]两个区间，将较小值放入tmpArr临时数组中
        while (i <= mid && j <= R) {
            tmpArr[idx++] = (arr[i] <= arr[j]) ? arr[i++] : arr[j++];
        }
        while (i <= mid) tmpArr[idx++] = arr[i++];
        while (j <= R) tmpArr[idx++] = arr[j++];
        // 将tmpArr数组中排序完毕的值放回原数组中
        for (int val : tmpArr) {
            arr[L++] = val;
        }
    }

    public static void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 4, 2, 7, 1, 10, 6, 9};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }


}
