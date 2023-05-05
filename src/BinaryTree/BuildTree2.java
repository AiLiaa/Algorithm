package BinaryTree;

import java.util.HashMap;
import java.util.Map;

/**
 * 从中序与前序遍历序列构造二叉树
 */
public class BuildTree2 {
    Map<Integer,Integer> map = new HashMap<>();

    public TreeNode solution(int[] preorder, int[] inorder) {
        // 方便根据后序的最后一个值，查找该值在中序的位置
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        return findNode(inorder,0,inorder.length,preorder,0,preorder.length);
    }

    public TreeNode findNode(int[] inorder, int inBegin, int inEnd, int[] preorder, int preBegin, int preEnd){
        // 不满足左开右闭，空元素
        if (inBegin >= inEnd || preBegin >= preEnd){
            return null;
        }

        int rootIndex = map.get(preorder[preBegin]);
        TreeNode root = new TreeNode(inorder[rootIndex]);

        int leftLen = rootIndex - inBegin; // 中序左子树个数，用来确定后序数列的左子树个数
        root.left = findNode(inorder,inBegin,rootIndex,
                preorder,preBegin + 1,preBegin + leftLen + 1);
        root.right = findNode(inorder,rootIndex + 1,inEnd,
                preorder,preBegin + leftLen + 1,preEnd);

        return root;
    }
}
