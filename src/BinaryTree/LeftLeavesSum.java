package BinaryTree;

/**
 * 左叶子之和
 *
 * 计算给定二叉树的所有左叶子之和。
 */
public class LeftLeavesSum {
    int sum = 0;
    // 递归
    public int solution1(TreeNode root){
        if (root == null) return 0;
        recursive(root,root);
        return sum;
    }
    public void recursive(TreeNode pre,TreeNode next){
        if (next == null) return;

        //前序遍历 是左叶子就加
        if (next.left == null && next.right == null && pre.left == next){
            sum += next.val;
        }
        recursive(next,next.left);
        recursive(next,next.right);
    }
}
