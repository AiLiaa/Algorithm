package BinaryTree;

/**
 * 修剪二叉搜索树
 *
 * 给定一个二叉搜索树，同时给定最小边界L 和最大边界 R。通过修剪二叉搜索树，使得所有节点的值在[L, R]中 (R>=L) 。
 * 你可能需要改变树的根节点，所以结果应当返回修剪好的二叉搜索树的新的根节点。
 *
 */
public class TrimBST {

    //递归
    public TreeNode trimBST(TreeNode root, int low, int high) {

        if (root == null) return null;

        // 寻找符合区间[low, high]的节点
        if (root.val < low) return trimBST(root.right,low,high);
        if (root.val > high) return trimBST(root.left,low,high);

        root.left = trimBST(root.left,low,high);// root->left接入符合条件的左孩子
        root.right = trimBST(root.right,low,high);// root->right接入符合条件的右孩子

        return root;

    }

    //迭代
    public TreeNode trimBST2(TreeNode root, int low, int high) {
        if (root == null) return null;

        // 处理头结点，让root移动到[L, R] 范围内，注意是左闭右闭
        while (root != null && (root.val < low || root.val > high)){
            if (root.val < low) root = root.right;
            else root = root.left;
        }
        TreeNode cur = root;

        // 此时root已经在[L, R] 范围内，处理左孩子元素小于L的情况
        while (cur != null){
            while (cur.left != null && cur.left.val < low){
                cur.left = cur.left.right;
            }
            cur = cur.left;
        }
        cur = root;

        // 此时root已经在[L, R] 范围内，处理右孩子大于R的情况
        while (cur != null){
            while (cur.right != null && cur.right.val > high){
                cur.right = cur.right.left;
            }
            cur = cur.right;
        }

        return root;
    }
}
