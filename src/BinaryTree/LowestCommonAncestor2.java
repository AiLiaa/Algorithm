package BinaryTree;

/**
 * 二叉搜索树的最近公共祖先
 *
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，
 * 最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
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
public class LowestCommonAncestor2 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        //目标在左子树
        if (root.val > q.val && root.val > p.val){
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            if (left != null) return left;
        }

        //目标在右子树
        if (root.val < q.val && root.val < p.val){
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            if (right != null) return right;
        }

        //找到[p,q]区间的节点
        return root;

    }
}
