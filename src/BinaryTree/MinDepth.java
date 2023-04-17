package BinaryTree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 */
public class MinDepth {
    // 递归
    public int solution1(TreeNode root){
        if (root == null){
            return 0;
        }
        int res = minDepth(root);
        return res;
    }
    public int minDepth(TreeNode root){
        if (root == null){
            return 0;
        }

        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);

        // 左右子树有一个为空时 这时候还不是最低点
        if (root.left == null && root.right != null){
            return rightDepth + 1;
        }
        if (root.right == null && root.left != null){
            return leftDepth + 1;
        }

        return Math.min(leftDepth,rightDepth) + 1;
    }

    // 迭代法
    public int solution2(TreeNode root){
        if (root == null) return 0;
        int depth = 0;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()){
            int size = deque.size();
            depth++;
            while (size > 0){
                TreeNode node = deque.poll();
                if (node.left != null) deque.offer(node.left);
                if (node.right != null) deque.offer(node.right);

                if (node.right == null && node.left == null){
                    return depth;
                }
                size--;
            }
        }
        return depth;
    }
}
