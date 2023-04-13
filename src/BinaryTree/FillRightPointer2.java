package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 填充每个节点的下一个右侧节点指针 2
 *
 * 相对于1的完全二叉树，这是普通二叉树
 *
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL 。
 * 初始状态下，所有next 指针都被设置为 NULL 。
 *
 * 输入：root = [1,2,3,4,5,null,7]
 * 输出：[1,#,2,3,#,4,5,7,#]
 *
 */
public class FillRightPointer2 {

    // 遍历最左结点，遍历每一层,不借助队列
    // 性能较差，需要剪枝
    public Node2 solution1(Node2 root){
        if (root == null) return root;

        Node2 left,right,cur,temp;
        root.next = null;
        cur = root;

        // 外循环：每一层的第一个结点
        // 内循环：一层结点
        while (cur != null){
            temp = cur;// 保留这层的最左的结点
            // 处理cur层的下一层
            while (cur != null){
                if (cur.left != null || cur.right != null){
                    left = cur.left;
                    right = cur.right;

                    // 左右都有
                    if (cur.left != null && cur.right != null){
                        System.out.println("111");
                        left.next = right;
                        Node2 find = cur;
                        while (find.next != null){
                            if (find.next.left != null){
                                right.next = find.next.left;
                                break;
                            }
                            if (find.next.right != null){
                                right.next = find.next.right;
                                break;
                            }
                            find = find.next;
                        }
                    }
                    // 有左没右
                    if (cur.left != null && cur.right == null){
                        System.out.println("222");
                        Node2 find = cur;
                        while (find.next != null){
                            if (find.next.left != null){
                                left.next = find.next.left;
                                break;
                            }
                            if (find.next.right != null){
                                left.next = find.next.right;
                                break;
                            }
                            find = find.next;
                        }
                    }
                    // 有右没左
                    // 找指向下一个可能很远的结点
                    if (cur.left == null && cur.right != null){
                        System.out.println("333");
                        Node2 find = cur;
                        while (find.next != null){
                            if (find.next.left != null){
                                right.next = find.next.left;
                                break;
                            }
                            if (find.next.right != null){
                                right.next = find.next.right;
                                break;
                            }
                            find = find.next;
                        }
                    }
                }
                cur = cur.next;
            }
            // 找下一层的最左结点
            while (temp != null){
                if (temp.left != null){
                    cur = temp.left;
                    break;
                }
                if (temp.right != null){
                    cur = temp.right;
                    break;
                }
                temp = temp.next;
            }
        }
        return root;
    }

    //BFS 广度优先遍历 借助队列
    public Node2 solution2(Node2 root) {
        if (root == null) return root;

        Queue<Node2> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            int size = queue.size();
            Node2 pre = null;// 前一个结点
            while (size > 0){
                Node2 node = queue.poll();
                // 如果前一个结点为空，说明是这一层的第一个
                // 不为空，则前一个结点的next指向出列结点
                if (pre != null){
                    pre.next = node;
                }
                pre = node;// 处理过的出列结点当作下次的前一个结点
                // 队列添加下一层的结点
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.left);
                size--;
            }
        }
        return root;
    }

    // 不用队列 性能最好 做法同solution1,优化版
    public Node2 solution3(Node2 root) {
        if (root == null) return root;
        Node2 cur = root;
        while (cur != null){
            // 访问当前层，处理下一层（当前层next已处理过）
            Node2 dummy = new Node2(0);// 下一层的最前面添加一个空结点
            Node2 pre = dummy;
            while (cur != null){
                if (cur.left != null){
                    pre.next = cur.left;
                    pre = pre.next;
                }
                if (cur.right != null){
                    pre.next = cur.right;
                    pre = pre.next;
                }
                cur = cur.next;
            }
            //把下一层串联成一个链表之后，让他赋值给cur，dummy.next就是下一层的第一个结点
            cur = dummy.next;
        }
        return root;
    }
}
