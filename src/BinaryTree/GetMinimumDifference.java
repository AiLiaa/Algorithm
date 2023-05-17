package BinaryTree;

/**
 * 二叉搜索树的最小绝对差
 *
 * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 *
 * 树中节点的数目范围是 [2, 104]
 * 0 <= Node.val <= 105
 *
 */
public class GetMinimumDifference {

    //中序遍历
    TreeNode pre = null;
    int min = Integer.MAX_VALUE;
    public int solution(TreeNode root){

        if (root == null){
            return 0;
        }
        solution(root.left);
        if (pre != null){
            int temp = root.val - pre.val;
            if (temp > 0){
                min = min > temp ? temp : min;
            }else {
                min = min > -temp ? -temp : min;
            }
        }
        pre = root;
        solution(root.right);
        return min;
    }

}
