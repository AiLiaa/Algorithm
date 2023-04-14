package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 另一棵树的子树
 *
 * 给你两棵二叉树 root 和 subRoot 。检验 root 中是否包含和 subRoot 具有相同结构和节点值的子树。
 * 如果存在，返回 true ；否则，返回 false 。
 *
 * 二叉树 tree 的一棵子树包括 tree 的某个节点和这个节点的所有后代节点。tree 也可以看做它自身的一棵子树。
 *
 * 输入：root = [3,4,5,1,2], subRoot = [4,1,2]
 * 输出：true
 */
public class SubtreeOfAnotherTree {
    // 层序遍历，递归判断是否为子树
    public boolean solution(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.val == subRoot.val){
                    if (isSubtree(node,subRoot)){
                        return true;
                    }
                }

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return false;
    }
    public boolean isSubtree(TreeNode root,TreeNode subRoot){
        if (root == null || subRoot == null){
            if (root == null && subRoot == null){
                return true;
            }
            return false;
        }

        if (root.val != subRoot.val){
            return false;
        }

        boolean left = isSubtree(root.left, subRoot.left);
        boolean right = isSubtree(root.right, subRoot.right);

        return left && right;
    }
}
