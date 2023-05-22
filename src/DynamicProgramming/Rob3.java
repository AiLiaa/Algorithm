package DynamicProgramming;

import BinaryTree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 打家劫舍 III
 *
 * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。
 * 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，
 * 聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 *
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 *
 * 提示：
 * 树的节点数在 [1, 104] 范围内
 * 0 <= Node.val <= 104
 *
 */
public class Rob3 {

    public int rob(TreeNode root) {
        int[] res = traversal(root);
        return Math.max(res[0],res[1]);
    }

    public int[] traversal(TreeNode root){
        //0记录不偷该节点，1记录偷该节点
        int[] res = new int[2];
        if (root == null) return res;

        int[] left = traversal(root.left);
        int[] right = traversal(root.right);

        //不偷该节点，偷孩子节点
        res[0] = Math.max(left[0],left[1]) + Math.max(right[0],right[1]);
        //偷该节点，不能偷子节点
        res[1] = root.val + left[0] + right[0];

        return res;
    }

}

