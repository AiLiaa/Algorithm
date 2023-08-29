package Other.Sort;

/**
 * 堆排序：
 *
 * 将传入的数组初始化成大根堆
 * 定义j = arr.length-1指向数组的末尾
 * 将堆顶元素与arr[j]交换后，--j指向数组的次末尾
 * 根据区间[0, j]重构大根堆，使得堆顶的最大值是区间[0, j]的最大值
 * 重复以上操作，直到数组顺序
 *
 * 堆初始化的时间复杂度为O(n)
 * 调整堆的时间复杂度为 O(logn) 次（对比次数 = 堆的高度-1 = log(n) 次)
 * 总体来说，在堆排序的过程中需要调整堆n次，所以堆排序的时间复杂度为 O(n*logn)
 *
 */
public class HeapSort {

    //调整堆
    //小结点不断下沉
    private static void heapAdjust(int[] heap, int i, int len) {
        // 记录传入节点值
        int tmp = heap[i];
        // 从i节点的左子节点开始，即i*2+1
        for (int k = i * 2 + 1; k < len; k = k * 2 + 1) {
            // 当左子节点小于右子节点，则让父节点与右子节点相比
            if (k + 1 < len && heap[k] < heap[k + 1]) {
                ++k;
            }
            // 若最大的子节点比传入节点大，则将最大的子节点的位置移到传入节点上
            if (heap[k] > tmp) {
                heap[i] = heap[k];
                i = k;
            } else {
                break;
            }
        }
        // 传入节点值放在最终的位置
        heap[i] = tmp;
    }

    public static void sort(int[] arr) {
        int len = arr.length;
        // 1. 构建大顶堆
        for (int i = len / 2 - 1; i >= 0; --i) {
            // 从第一个非叶子结点从下至上，从右至左调整结构
            heapAdjust(arr, i, len);
        }
        // 2. 每一趟排序，都将大顶堆的堆顶与数组的索引j处的值交换
        // 索引j最开始指向数组尾部，随着每一趟排序的结束自减，直到指向数组头部
        for (int j = len - 1; j > 0; --j) {
            swap(arr, 0, j);
            heapAdjust(arr, 0, j);
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
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }


}
