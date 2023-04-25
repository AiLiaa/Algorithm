package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 路径总和2
 *
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * 叶子节点 是指没有子节点的节点。
 *
 */
public class PathSum2 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    int sum = 0;
    // 回溯
    public List<List<Integer>> solution(TreeNode root, int targetSum) {
        if (root == null) return res;
        backtracking(root,targetSum);
        return res;
    }
    public void backtracking(TreeNode root, int targetSum){
        sum += root.val;
        path.add(root.val);

        if (root.left == null && root.right == null){
            if (sum == targetSum){
                res.add(new ArrayList<>(path));
            }
            return;
        }

        if (root.left != null){
            backtracking(root.left,targetSum);
            path.removeLast();
            sum -= root.left.val;
        }
        if (root.right != null){
            backtracking(root.right,targetSum);
            path.removeLast();
            sum -= root.right.val;
        }
    }
}
