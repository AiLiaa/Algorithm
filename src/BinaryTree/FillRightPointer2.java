package BinaryTree;

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

    public Node2 solution(Node2 root){
        if (root == null) return root;

        Node2 left,right,cur,temp;
        root.next = null;
        cur = root;
        boolean flag = true;

        while (cur != null){
            temp = cur;// 保留这层的最左的结点

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
            if (cur == null){
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
        }

        return root;
    }
}
