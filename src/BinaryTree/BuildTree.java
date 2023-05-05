package BinaryTree;

import java.util.HashMap;
import java.util.Map;

/**
 * 从中序与后序遍历序列构造二叉树
 *
 * 给定两个整数数组 inorder 和 postorder ，
 * 其中 inorder 是二叉树的中序遍历，
 * postorder 是同一棵树的后序遍历，请你构造并返回这颗二叉树。
 *
 * 输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
 * 输出：[3,9,20,null,null,15,7]
 *
 */

public class BuildTree {

    /**
     * 第一步：如果数组大小为零的话，说明是空节点了。
     * 第二步：如果不为空，那么取后序数组最后一个元素作为节点元素。
     * 第三步：找到后序数组最后一个元素在中序数组的位置，作为切割点
     * 第四步：切割中序数组，切成中序左数组和中序右数组 （顺序别搞反了，一定是先切中序数组）
     * 第五步：切割后序数组，切成后序左数组和后序右数组
     * 第六步：递归处理左区间和右区间
     */
    Map<Integer,Integer> map = new HashMap<>();

    public TreeNode solution(int[] inorder, int[] postorder) {
        // 方便根据后序的最后一个值，查找该值在中序的位置
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        return findNode(inorder,0,inorder.length,postorder,0,postorder.length);
    }

    public TreeNode findNode(int[] inorder, int inBegin, int inEnd, int[] postorder, int postBegin, int postEnd){
        // 不满足左开右闭，空元素
        if (inBegin >= inEnd || postBegin >= postEnd){
            return null;
        }

        int rootIndex = map.get(postorder[postEnd- 1]);
        TreeNode root = new TreeNode(inorder[rootIndex]);

        int leftLen = rootIndex - inBegin; // 保存中序左子树个数，用来确定后序数列的个数
        root.left = findNode(inorder,inBegin,rootIndex,
                postorder,postBegin,postBegin + leftLen);
        root.right = findNode(inorder,rootIndex + 1,inEnd,
                postorder,postBegin + leftLen,postEnd - 1);

        return root;
    }
}
