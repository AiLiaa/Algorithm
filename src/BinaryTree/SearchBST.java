package BinaryTree;

/**
 * 二叉搜索树中的搜索
 *
 * 给定二叉搜索树（BST）的根节点root和一个整数值val。
 * 你需要在 BST 中找到节点值等于val的节点。 返回以该节点为根的子树。 如果节点不存在，则返回null
 *
 * 输入：root = [4,2,7,1,3], val = 2
 * 输出：[2,1,3]
 */
public class SearchBST {
    //递归
    TreeNode node = null;
    public TreeNode solution1(TreeNode root, int val) {

        if (root == null) return null;
        if (val == root.val) node = root;

        if (val > root.val) solution1(root.right,val);
        if (val < root.val) solution1(root.left,val);

        return node;
    }

    //迭代
    public TreeNode solution2(TreeNode root, int val) {
        while (root != null){
            if (val > root.val) root = root.right;
            else if (val < root.val) root = root.left;
            else return root;
        }
        return null;
    }
}
