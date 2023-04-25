package BinaryTree;

import java.util.Stack;

/**
 * 路径总和
 *
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * 说明: 叶子节点是指没有子节点的节点。
 */
public class PathSum {
    int sum = 0;
    boolean res = false;
    // 递归回溯
    public boolean solution(TreeNode root, int targetSum) {

        if (root == null) return false;
        backtracking(root,targetSum);
        return res;
    }
    public void backtracking(TreeNode root, int targetSum){
        sum += root.val;
        if (root.right == null && root.left == null){
            if (sum == targetSum){
                res = true;
            }
            return;
        }
        if (root.left != null){
            backtracking(root.left,targetSum);
            sum -= root.left.val;
        }
        if (root.right != null){
            backtracking(root.right,targetSum);
            sum -= root.right.val;
        }
    }

    //回溯简洁版
    public boolean solution2(TreeNode root, int targetSum) {

        if (root == null) return false; // 为空退出

        // 叶子节点判断是否符合
        if (root.left == null && root.right == null) return root.val == targetSum;

        // 求两侧分支的路径和
        return solution2(root.left, targetSum - root.val) || solution2(root.right, targetSum - root.val);
    }

    // 迭代 栈
    public boolean solution3(TreeNode root, int targetSum){
        if (root == null) return false;
        Stack<Object> stack = new Stack<>();
        stack.push(root);
        stack.push(root.val);
        while (!stack.isEmpty()){
            int size = stack.size();
            while (size > 0){
                int sum = (int) stack.pop();
                TreeNode node = (TreeNode) stack.pop();

                if (node.right == null && node.left == null && sum == targetSum) return true;

                if (node.left != null){
                    stack.push(node.left);
                    stack.push(node.left.val + sum);
                }

                if (node.right != null){
                    stack.push(node.right);
                    stack.push(node.right.val + sum);
                }
                size = size - 2;
            }
        }
        return false;
    }
}
