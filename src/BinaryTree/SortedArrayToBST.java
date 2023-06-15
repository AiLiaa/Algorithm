package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 将有序数组转换为二叉搜索树
 *
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums 按 严格递增 顺序排列
 *
 */
public class SortedArrayToBST {

    //递归
    public TreeNode sortedArrayToBST(int[] nums) {
        return middle(0,nums.length - 1,nums);
    }

    //二分法确定node
    public TreeNode middle(int left,int right,int[] nums){

        if (left <= right){

            int middle = left + ((right - left) >> 1);
            TreeNode node = new TreeNode(nums[middle]);

            node.left = middle(left,middle - 1,nums);
            node.right = middle(middle + 1,right,nums);

            return node;
        }
        return null;

    }

    //迭代
    public TreeNode sortedArrayToBST1(int[] nums) {
        if (nums.length == 0) return null;

        //根节点初始化
        TreeNode root = new TreeNode(-1);
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> leftQueue = new LinkedList<>();
        Queue<Integer> rightQueue = new LinkedList<>();

        // 根节点入队列
        nodeQueue.offer(root);
        // 0为左区间下标初始位置
        leftQueue.offer(0);
        // nums.size() - 1为右区间下标初始位置
        rightQueue.offer(nums.length - 1);

        while (!nodeQueue.isEmpty()) {
            TreeNode currNode = nodeQueue.poll();
            int left = leftQueue.poll();
            int right = rightQueue.poll();
            int mid = left + ((right - left) >> 1);

            // 将mid对应的元素给中间节点
            currNode.val = nums[mid];

            // 处理左区间
            if (left <= mid - 1) {
                currNode.left = new TreeNode(-1);
                nodeQueue.offer(currNode.left);
                leftQueue.offer(left);
                rightQueue.offer(mid - 1);
            }

            // 处理右区间
            if (right >= mid + 1) {
                currNode.right = new TreeNode(-1);
                nodeQueue.offer(currNode.right);
                leftQueue.offer(mid + 1);
                rightQueue.offer(right);
            }
        }
        return root;
    }
}
