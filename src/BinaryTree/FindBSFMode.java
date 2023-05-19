package BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉搜索树中的众数
 *
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 *
 * 示例 1：
 * 输入：root = [1,null,2,2]
 * 输出：[2]
 *
 * 示例 2：
 * 输入：root = [0]
 * 输出：[0]
 *
 * 提示：
 * 树中节点的数目在范围 [1, 104] 内
 * -105 <= Node.val <= 105
 *
 */
public class FindBSFMode {

    List<Integer> resList = new ArrayList<>();
    int count = 0;
    int maxCount = 0;
    TreeNode pre = null;

    public int[] solution(TreeNode root){
        findMode1(root);
        int[] res = new int[resList.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = resList.get(i);
        }
        return res;
    }

    public void findMode1(TreeNode root){
        if (root == null) return;

        findMode1(root.left);

        if (pre == null || root.val != pre.val){
            count = 1;
        }else {
            count++;
        }
        //出现新的众数，清空list
        if (count > maxCount){
            resList.clear();
            resList.add(root.val);
            maxCount = count;
        }else if (maxCount == count){
            resList.add(root.val);
        }
        pre = root;
        findMode1(root.right);
    }
}
