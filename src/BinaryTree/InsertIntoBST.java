package BinaryTree;

/**
 * 二叉搜索树中的插入操作
 *
 * 给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。
 * 返回插入后二叉搜索树的根节点。 输入数据保证，新值和原始二叉搜索树中的任意节点值都不同。
 *
 * 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回任意有效的结果。
 *
 * 不重构搜索数，直接遇到空值插入
 */
public class InsertIntoBST {
    //递归法
    public TreeNode solution1(TreeNode root, int val) {

        if (root == null){
            TreeNode node = new TreeNode(val);
            return node;
        }
        if (val < root.val) root.left = solution1(root.left,val);
        if (val > root.val) root.right = solution1(root.right,val);

        return root;
    }

    //迭代法
    public TreeNode solution2(TreeNode root,int val){
        if (root == null) return new TreeNode(val);

        TreeNode cur = root;
        TreeNode parent = root;

        while (cur != null){
            parent = cur;
            if (cur.val > val) cur = cur.left;
            else cur = cur.right;

        }
        if (parent.val > val) parent.left = new TreeNode(val);
        else parent.right = new TreeNode(val);

        return root;

    }

}
