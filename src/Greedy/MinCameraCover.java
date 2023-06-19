package Greedy;

import BinaryTree.TreeNode;

/**
 * 监控二叉树
 *
 * 给定一个二叉树，我们在树的节点上安装摄像头。
 * 节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。
 * 计算监控树的所有节点所需的最小摄像头数量。
 *
 * 给定树的节点数的范围是 [1, 1000]。
 * 每个节点的值都是 0
 *
 * 后序遍历，记录结点状态
 * 0：节点无覆盖
 * 1：节点有摄像头
 * 2：节点有覆盖
 *
 */
public class MinCameraCover {

    int result = 0;
    public int traversal(TreeNode root) {

        //空结点覆盖,因为叶子结点一定是有覆盖且无摄像头
        if (root == null) return 2;

        int left = traversal(root.left);
        int right = traversal(root.right);

        // 左右节点都有覆盖
        if (right == 2 && left == 2) return 0;

        // left == 0 && right == 0 左右节点无覆盖
        // left == 1 && right == 0 左节点有摄像头，右节点无覆盖
        // left == 0 && right == 1 左节点有无覆盖，右节点摄像头
        // left == 0 && right == 2 左节点无覆盖，右节点覆盖
        // left == 2 && right == 0 左节点覆盖，右节点无覆盖
        if (right == 0 || left == 0) {
            result++;
            return 1;
        }

        // left == 1 && right == 2 左节点有摄像头，右节点有覆盖
        // left == 2 && right == 1 左节点有覆盖，右节点有摄像头
        // left == 1 && right == 1 左右节点都有摄像头
        if (left == 1 || right == 1) return 2;

        // return -1 逻辑不会走到这里。
        return -1;
    }

    public int minCameraCover(TreeNode root) {
        if (traversal(root) == 0){
            result++;
        }
        return result;
    }
}
