package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 在每个树行中找最大值
 *
 * 给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。
 */
public class LayersMaximumValue {

    public List<Integer> solution(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        int max = Integer.MIN_VALUE;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            // 每层node的数目
            int size = queue.size();
            // 这里要使用固定大小size，不要使用que.size()，因为que.size是不断变化的
            while (size > 0){
                TreeNode node = queue.poll();
                max = max > node.val ? max : node.val;
                // 添加下一层的node
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                size--;
            }
            res.add(max);
            max = Integer.MIN_VALUE;
        }
        return res;
    }
}
