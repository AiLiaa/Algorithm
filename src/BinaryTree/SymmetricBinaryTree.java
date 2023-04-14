package BinaryTree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 对称二叉树
 *
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 *
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 *
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 */
public class SymmetricBinaryTree {

    boolean res;
    // 递归
    public boolean solution1(TreeNode root){
        res = true;
        isSymmetric(root.left,root.right);
        return res;
    }
    public void isSymmetric(TreeNode leftNode,TreeNode rightNode){
        // 终止条件
        if (leftNode == null || rightNode == null){ // 有一个空，false,return
            if (leftNode == null && rightNode == null){ // 有两个空，return
                return;
            }
            res = false;
            return;
        }

        // 递归逻辑
        if (leftNode.val != rightNode.val){
            res = false;
            return;// 已经确定不对称了，不用递归下去了
        }

        // 递归下一层
        isSymmetric(leftNode.left,rightNode.right);
        isSymmetric(leftNode.right,rightNode.left);

    }

    // 迭代法 使用队列
    public boolean solution2(TreeNode root){
        if (root == null) return true;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root.left);
        deque.offer(root.right);

        while (!deque.isEmpty()){
            TreeNode leftNode = deque.pollFirst();
            TreeNode rightNode = deque.pollLast();
            if (leftNode == null && rightNode == null){
                continue;
            }
            if (leftNode == null || rightNode == null || leftNode.val != rightNode.val){
                return false;
            }
            deque.offerFirst(leftNode.left);
            deque.offerFirst(leftNode.right);
            deque.offerLast(rightNode.right);
            deque.offerLast(rightNode.left);

        }
        return true;
    }
}
