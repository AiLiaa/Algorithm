package BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的所有路径
 *
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 输入：root = [1,2,3,null,5]
 * 输出：["1->2->5","1->3"]
 */
public class BinaryTreeAllPaths {
    
    List<String> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    // 递归回溯法
    public List<String> solution(TreeNode root){

        if (root == null) return res;
        backtracking(root,path);

        return res;
    }
    public void backtracking(TreeNode root,List<Integer> path){
        path.add(root.val);//中
        // 终止条件
        if (root.left == null && root.right == null){

            StringBuilder sb = new StringBuilder();
            int size = path.size();
            for (int i = 0; i < size - 1; i++) {
                sb.append(path.get(i)).append("->");
            }
            sb.append(path.get(size - 1));//最后一个，就不包括"->"
            res.add(sb.toString());//加入结果集
            return;
        }
        // 左
        if (root.left != null){
            backtracking(root.left,path);
            path.remove(path.size() - 1);//回溯
        }
        // 右
        if (root.right != null){
            backtracking(root.right,path);
            path.remove(path.size() - 1);//回溯
        }
    }
}
