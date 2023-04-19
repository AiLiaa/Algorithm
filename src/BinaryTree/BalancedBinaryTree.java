package BinaryTree;

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为：一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 *
 * leetcode的题目中都是以节点为一度，即根节点深度是1。维基百科上定义用边为一度，即根节点的深度是0
 *
 */
public class BalancedBinaryTree {
    // 递归
    public boolean solution(TreeNode root){
        if (root == null) return true;
        int res = getDepth(root);
        return res == -1 ? false : true;
    }

    //后序遍历
    //如果已经不是二叉平衡树了，可以返回-1 来标记已经不符合平衡树的规则了。
    int getDepth(TreeNode root){
        if (root == null) return 0;

        // 左
        int leftDepth = getDepth(root.left);
        if (leftDepth == -1) return -1;
        // 右
        int rightDepth = getDepth(root.right);
        if (rightDepth == -1) return -1;
        // 中
        return Math.abs(leftDepth - rightDepth) > 1 ? -1 : 1 + Math.max(leftDepth,rightDepth);
    }

}
