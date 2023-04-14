package BinaryTree;

/**
 * 相同的树
 *
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 * 输入：p = [1,2,3], q = [1,2,3]
 * 输出：true
 *
 */
public class SameTree {
    boolean res;
    public boolean solution(TreeNode p,TreeNode q){
        res = true;
        isSame(p,q);
        return res;
    }
    public void isSame(TreeNode p,TreeNode q){
        if (p == null || q == null){
            if (p == null && q == null){
                return;
            }
            res = false;
            return;
        }

        if (p.val != q.val){
            res = false;
            return;
        }

        isSame(p.left,q.left);
        isSame(p.right,q.right);

    }
}
