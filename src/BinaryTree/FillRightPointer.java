package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 填充每个节点的下一个右侧节点指针
 *
 * 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * 初始状态下，所有next 指针都被设置为 NULL。
 *
 * 输入：root = [1,2,3,4,5,6,7]
 * 输出：[1,#,2,3,#,4,5,6,7,#]
 *
 * 层序遍历
 */

class Node2 {
    public int val;
    public Node2 left;
    public Node2 right;
    public Node2 next;

    public Node2() {}

    public Node2(int _val) {
        val = _val;
    }

    public Node2(int _val, Node2 _left, Node2 _right, Node2 _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

public class FillRightPointer {

    /**
     * 指针BFS 不借助队列
     *
     * 根据 23层处理 4567层
     *          1
     *       2 -> 3
     *     4  5  6  7
     */
    public Node2 solution1(Node2 root) {
        if (root == null) return root;

        Node2 left,right,cur,temp;
        root.next = null;
        cur = root;

        // 外循环：每一层的第一个左结点
        // 内循环：一层结点
        while (cur.left != null){
            temp = cur;// 保留这层的最左结点
            // 处理cur层的下一层
            while (cur != null){

                left = cur.left;
                right = cur.right;

                // 指针
                left.next = right;
                if (cur.next != null) right.next = cur.next.left;

                cur = cur.next;
            }
            cur = temp.left;//下一层
        }
        return root;
    }

    // 递归
    public Node2 solution2(Node2 root) {
        dfs(root,null);
        return root;
    }
    private void dfs(Node2 cur,Node2 next){
        if (cur == null) return;
        cur.next = next;
        dfs(cur.left,cur.right);
        dfs(cur.right,cur.next == null ? null : cur.next.left);
    }

    // 借助队列
    public Node2 solution3(Node2 root) {
        if (root == null) {
            return root;
        }
        // 初始化队列同时将第一层节点加入队列中，即根节点
        Queue<Node2> queue = new LinkedList<Node2>();
        queue.add(root);
        // 外层的 while 循环迭代的是层数
        while (!queue.isEmpty()) {
            // 记录当前队列大小
            int size = queue.size();
            // 遍历这一层的所有节点
            for (int i = 0; i < size; i++) {
                // 从队首取出元素
                Node2 node = queue.poll();
                // 连接
                if (i < size - 1) {
                    node.next = queue.peek();
                }
                // 拓展下一层节点
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return root;
    }
}
