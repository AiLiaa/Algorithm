package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 验证二叉搜索树
 *
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 *
 * 有效 二叉搜索树定义如下：
 *
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 */
public class IsValidBST {

    // 二叉搜索树中序遍历的数组从小到大
    List<Integer> res = new ArrayList<>();
    public boolean solution1(TreeNode root) {
        isValidBST(root);
        for (int i = 1; i < res.size(); i++) {
            if (res.get(i) <= res.get(i - 1)) return false;
        }
        return true;
    }
    public void isValidBST(TreeNode root) {
        if (root == null) return;
        isValidBST(root.left);
        res.add(root.val);
        isValidBST(root.right);
    }


    // 记录前一个结点，中序遍历比较
    TreeNode pre = null;
    public boolean solution2(TreeNode root) {
        if (root == null) return true;

        boolean left = solution2(root.left);
        if (pre != null && pre.val >= root.val) return false;
        pre = root;//记录前一个结点
        boolean right = solution2(root.right);

        return left && right;
    }

    // 迭代
    public boolean solution3(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;// 左
            }
            // 中，处理
            TreeNode pop = stack.pop();
            if (pre != null && pop.val <= pre.val) {
                return false;
            }
            pre = pop;

            root = pop.right;// 右
        }
        return true;
    }

}
