package BinaryTree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 树的左下角值
 */
public class LowerLeftCornerValue {
    int maxDepth = Integer.MIN_VALUE;
    int val = 0;
    // 递归 回溯
    public int solution1(TreeNode root){
        if (root == null) return 0;
        backtracking(root,0);
        return val;
    }
    public void backtracking(TreeNode root,int depth){

        if (root.left == null && root.right == null){
            if (depth > maxDepth){
                maxDepth = depth;
                val = root.val;
            }
            return;
        }
        if (root.left != null){
            depth++;
            backtracking(root.left,depth);// 递归
            depth--;// 回溯
        }
        if (root.right != null){
            depth++;
            backtracking(root.right,depth);
            depth--;
        }
    }

    // 层序遍历
    public int solution2(TreeNode root){
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int res = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == 0) res = node.val;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return res;
    }
}
