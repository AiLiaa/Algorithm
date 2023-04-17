package BinaryTree;
/**
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 * 示例： 给定二叉树 [3,9,20,null,null,15,7]，
 * 返回3
 */

import java.util.Deque;
import java.util.LinkedList;

public class MaxDepth {
    // 递归法
    public int solution1(TreeNode root) {
        // 结束条件
        if (root == null){
            return 0;
        }
        // 开始递归
        int leftDepth = solution1(root.left);
        int rightDepth = solution1(root.right);

        // 递归栈pop时，进行+1。最后执行的return 返回的是最大的depth
        return Math.max(leftDepth,rightDepth) + 1;
    }

    // 迭代法
    public int solution2(TreeNode root){
        if (root == null){
            return 0;
        }
        int depth = 0;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()){
            int size = deque.size();
            depth ++;
            while (size > 0){
                TreeNode node = deque.poll();

                if (node.left != null) deque.offer(node.left);
                if (node.right != null) deque.offer(node.right);

                size--;
            }

        }
        return depth;
    }
}
