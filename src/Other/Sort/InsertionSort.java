package Other.Sort;

import java.util.Arrays;

/**
 * 插入排序
 *
 * 就像玩扑克的时候整理手牌一样，在手上已经整理好的牌里找到合适的位置，将拿到的牌插入到那个合适的位置
 *
 * 利用到了数组中已排序过的部分有序的特性
 *
 * 最好情况下，数组已经是有序的，每插入一个元素，只需要考查前一个元素，时间复杂度为O(n)
 * 最坏情况下的复杂度为 O(n2)
 * 平均时间复杂度为O(n2)
 *
 */
public class InsertionSort {

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; ++i) {
            // 每趟插入排序前，数组区间[0,i]经过上一趟插入排序处理后，是有序的
            for (int j = i + 1; j > 0; --j) {
                // 数组元素交换
                if (arr[j - 1] > arr[j]){
                    swap(arr, j - 1, j);
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

    //二分查找优化
    public static void optSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; ++i) {
            int j = i + 1;
            // 二分查找找到合适的插入位置
            int insertIdx = binarySearch(arr, 0, i, arr[j]);
            // 存储需要插入的元素
            int tmp = arr[j];
            // 将数组区间(insertIdx,j)中的元素往后各移一位
            for(;j>insertIdx;--j){
                arr[j]=arr[j-1];
            }
            // 为指定下标赋值
            arr[insertIdx] = tmp;
        }
    }

    private static int binarySearch(int[] arr, int start, int end, int key) {
        // 当key <= 数组中最小元素 时，返回数组头的索引
        if (key <= arr[start]) {
            return start;
            // 当key >= 数组中最大元素时，返回数组尾的索引+1
        } else if (key >= arr[end]) {
            return end + 1;
            // 否则递归进行二分查找
        } else {
            int mid = start + (end - start) / 2;
            if (key > arr[mid]) {
                return binarySearch(arr, mid + 1, end, key);
            } else {
                return binarySearch(arr, start, mid, key);
            }
        }
    }



}
