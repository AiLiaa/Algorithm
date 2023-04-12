package BinaryTree;

import java.util.*;

/**
 * 层序遍历二叉树
 *
 * 需要借用一个辅助数据结构即队列来实现，队列先进先出，符合一层一层遍历的逻辑，广度优先
 * 而用栈先进后出适合模拟深度优先遍历也就是递归的逻辑。
 *
 */

public class LevelTraversal {
    // BFS 迭代 借助队列
    public List<List<Integer>> solution1(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            // 每层node的数目
            int size = queue.size();
            // 这里要使用固定大小size，不要使用que.size()，因为que.size是不断变化的
            while (size > 0){
                TreeNode node = queue.poll();
                list.add(node.val);
                // 添加下一层的node
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                size--;
            }
            res.add(list);
        }
        return res;
    }

    //DFS--递归方式
    public List<List<Integer>> solution2(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        recuesive(root,0,res);

        return res;
    }

    public void recuesive(TreeNode node, int deep, List<List<Integer>> res){
        if (node == null) return;
        deep++;

        if (res.size() < deep) {
            //当层级增加时，list的Item也增加，利用list的索引值进行层级界定
            List<Integer> item = new ArrayList<Integer>();
            res.add(item);
        }
        res.get(deep - 1).add(node.val);

        recuesive(node.left, deep, res);
        recuesive(node.right, deep, res);
    }
}
