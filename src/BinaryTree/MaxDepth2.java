package BinaryTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个 N 叉树，找到其最大深度。
 *
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 */
class Node3 {
    public int val;
    public List<Node3> children;

    public Node3() {}

    public Node3(int _val) {
        val = _val;
    }

    public Node3(int _val, List<Node3> _children) {
        val = _val;
        children = _children;
    }
};

public class MaxDepth2 {
    // 递归
    public int solution1(Node3 root){
        if(root == null){
            return 0;
        }
        int depth = 0;
        int size = root.children.size();
        for(int i = 0;i < size;i++){
            depth = Math.max(depth,solution1(root.children.get(i)));
        }
        return depth + 1;
    }
    // 迭代
    public int solution2(Node3 root){
        if (root == null)   return 0;
        int depth = 0;
        Queue<Node3> que = new LinkedList<>();
        que.offer(root);
        while (!que.isEmpty())
        {
            depth ++;
            int len = que.size();
            while (len > 0)
            {
                Node3 node = que.poll();
                for (int i = 0; i < node.children.size(); i++)
                    if (node.children.get(i) != null)
                        que.offer(node.children.get(i));
                len--;
            }
        }
        return depth;
    }
}
