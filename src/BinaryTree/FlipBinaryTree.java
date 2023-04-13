package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 翻转二叉树
 *
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 */
public class FlipBinaryTree {

    // DFS 递归
    public TreeNode solution1(TreeNode root) {
        if (root == null) return root;
        flip(root);
        return root;
    }
    public void flip(TreeNode root){
        if (root == null) return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        flip(root.left);
        flip(root.right);
    }

    // BFS 层序
    public TreeNode solution2(TreeNode root) {
        if (root == null) return root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size > 0){
                TreeNode node = queue.poll();

                swap(node);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                size--;
            }
        }
        return root;
    }
    public void swap(TreeNode root){
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
