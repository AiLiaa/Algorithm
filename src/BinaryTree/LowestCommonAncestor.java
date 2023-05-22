package BinaryTree;

/**
 * 二叉树的最近公共祖先
 *
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，
 * 最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 *
 * 示例 1: 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 *
 * 示例 2: 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 *
 * 说明:
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉树中。
 *
 * 从下往上查找
 * 后序遍历
 *
 * 求最小公共祖先，需要从底向上遍历，那么二叉树，只能通过后序遍历（即：回溯）实现从底向上的遍历方式。
 * 在回溯的过程中，必然要遍历整棵二叉树，即使已经找到结果了，依然要把其他节点遍历完，因为要使用递归函数的返回值（也就是代码中的left和right）做逻辑判断。
 * 要理解如果返回值left为空，right不为空为什么要返回right，为什么可以用返回right传给上一层结果。
 *
 *
 * 搜索一条边的写法：
 * if (递归函数(root->left)) return ;
 * if (递归函数(root->right)) return ;
 *
 * 搜索整个树写法：
 * left = 递归函数(root->left);
 * right = 递归函数(root->right);
 * left与right的逻辑处理;
 *
 */
public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) return root;
        if (left != null && right == null){
            return left;
        }else {
            return right;
        }
    }
}
