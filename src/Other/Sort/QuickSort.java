package Other.Sort;
/**
 * 快排
 *
 * 在待排序数组中取一个值当作基准值；
 * 将待排序数组中所有大于基准值的元素移到数组的右边；
 * 把所有小于基准值的元素移到数组的左边；
 * 递归地将小于基准值的数组区间和大于基准值的数组区间进行排序。
 *
 * 快速排序的时间复杂度是不稳定的，在 O(n*logn)~O(n^2) 之间（最坏：每次选基准值都选到该区间的最大 / 最小值）
 * 快排的最好情况是：每次选到的基准值都是数组区间的中位数，这样子就可以把数组折半划分，需要拆分logn次，
 * 而拆分后的每次排序都需要遍历排序数组，每次排序的总时间复杂度是O(n)，此时就和归并排序基本一致了，时间复杂度为 O(n*logn)
 *
 */
public class QuickSort {

    private void sort(int[] arr, int L, int R) {
        // 递归出口为L追上R的时候
        if (L >= R) return;
        int i = L, j = R;
        int key = arr[L];
        while (i < j) {
            // 从右边开始，找到第一个小于key的数
            while (i < j && arr[j] >= key) --j;
            // 再从左边开始，找到第一个大于key的数
            while (i < j && arr[i] <= key) ++i;
            swap(arr, i, j);
        }
        // 将基准值放在划分数组大小的中间轴上
        swap(arr, L, i);
        // 递归进行排序
        sort(arr, L, i);
        sort(arr, i + 1, R);
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 4, 2, 7, 1, 10, 6, 9};
        QuickSort qs = new QuickSort();
        qs.sort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
