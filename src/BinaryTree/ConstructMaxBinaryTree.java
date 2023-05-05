package BinaryTree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 最大二叉树
 *
 * 给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
 *
 * 二叉树的根是数组中的最大元素。
 * 左子树是通过数组中最大值左边部分构造出的最大二叉树。
 * 右子树是通过数组中最大值右边部分构造出的最大二叉树。
 * 通过给定的数组构建最大二叉树，并且输出这个树的根节点。
 *
 * 前序，先处理中，在递归左右
 */
public class ConstructMaxBinaryTree {

    public TreeNode solution(int[] nums) {
        return findNode(nums, 0, nums.length);
    }

    public TreeNode findNode(int[] nums, int begin, int end){
        if (begin >= end){
            return null;
        }

        //找到最大值和下标
        int index = begin;
        int tempMax = nums[begin];
        for (int i = begin; i < end; i++) {
            if (nums[i] > tempMax){
                tempMax = nums[i];
                index = i;
            }
        }

        TreeNode root = new TreeNode(nums[index]);
        root.left = findNode(nums,begin,index);
        root.right = findNode(nums,index + 1, end);

        return root;
    }

    public static void main(String[] args) {
        ConstructMaxBinaryTree c = new ConstructMaxBinaryTree();
        c.solution(new int[]{3,2,1,6,0,5});
    }
}
