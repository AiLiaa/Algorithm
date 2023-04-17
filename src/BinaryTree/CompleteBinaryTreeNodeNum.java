package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 完全二叉树的结点个数
 *
 * 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，
 * 并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1 ~ 2h次方个节点。
 *
 */
public class CompleteBinaryTreeNodeNum {
    // 对于普通二叉树 递归
    public int solution1(TreeNode root){
        if (root == null) return 0;

        int leftNum = solution1(root.left);// 左
        int rightNum = solution1(root.right);// 右
        int sum = leftNum + rightNum + 1;// 中

        return sum;
    }

    // 对于普通二叉树 迭代法
    public int solution2(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int result = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size -- > 0) {
                TreeNode cur = queue.poll();
                result++;
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
        }
        return result;
    }

    // 针对完全二叉树解法  判断左右是不是满二叉树
    public int solution3(TreeNode root){
        if (root == null) return 0;
        TreeNode left = root.left;
        TreeNode right = root.right;

        // 如果左右深度相同，在完全二叉树中，这个子树就是满二叉树
        int leftDepth = 0,rightDepth = 0;
        while (left != null){
            left = left.left;
            leftDepth++;
        }
        while (right != null){
            right = right.right;
            rightDepth++;
        }
        if (leftDepth == rightDepth){
            return (2 << leftDepth) - 1;
        }

        int l = solution3(root.left);
        int r = solution3(root.right);
        int sum = l + r + 1;

        return sum;
    }

}
