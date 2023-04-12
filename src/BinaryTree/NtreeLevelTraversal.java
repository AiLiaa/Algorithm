package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * N叉数层序遍历
 *
 * 给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。
 * 树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。
 *
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：[[1],[3,2,4],[5,6]]
 *
 * 输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * 输出：[[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]
 *
 */
class Node1 {
    public int val;
    public List<Node1> children;

    public Node1() {}

    public Node1(int _val) {
        val = _val;
    }

    public Node1(int _val, List<Node1> _children) {
        val = _val;
        children = _children;
    }
};

public class NtreeLevelTraversal {

    public List<List<Integer>> solution(Node1 root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        int size;
        Node1 node;
        List<Integer> list;
        Queue<Node1> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            size = queue.size();
            list = new ArrayList<>();
            while (size > 0){
                node = queue.poll();
                list.add(node.val);
                // 添加每一个子结点
                for (Node1 n : node.children) {
                    queue.offer(n);
                }
                size--;
            }
            res.add(list);
        }
        return res;
    }
}
