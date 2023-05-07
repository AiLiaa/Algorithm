package BinaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 迭代遍历二叉树
 */
public class IterativeTraversal {
    //前序 中左右
    public List<Integer> solution1(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        Stack<TreeNode> st = new Stack<>();
        st.push(root);

        while (!st.isEmpty()){
            TreeNode node = st.pop();
            res.add(node.val);
            // 栈特点，把右先放进去，先出来的是左
            if (node.right != null){
                st.push(node.right);
            }
            if (node.left != null){
                st.push(node.left);
            }
        }
        return res;
    }

    // 中序 左中右
    public List<Integer> solution2(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }

        Stack<TreeNode> st = new Stack<>();
        TreeNode cur = root;

        while (!st.isEmpty() || cur != null){
            if (cur != null){ // 指针访问到最底下的左边
                st.push(cur);
                cur = cur.left;//左
            }else {
                //中
                cur = st.pop();
                res.add(cur.val);
                //右
                cur = cur.right;
            }
        }
        return res;
    }

    // 后序 左右中
    public List<Integer> solution3(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        Stack<TreeNode> st = new Stack<>();
        st.push(root);

        // 先中右左
        while (!st.isEmpty()){
            TreeNode node = st.pop();
            res.add(node.val);
            // 栈特点，把左先放进去，先出来的是右
            if (node.left != null){
                st.push(node.left);
            }
            if (node.right != null){
                st.push(node.right);
            }
        }
        // 再反转
        Collections.reverse(res);
        return res;
    }

    // 统一风格的前中后迭代遍历
    /**
     * 将访问的节点放入栈中，把要处理的节点也放入栈中但是要做标记。
     * 如何标记呢，就是要处理的节点放入栈之后，紧接着放入一个空指针作为标记。 这种方法也可以叫做标记法。
     */
    public List<Integer> solution4(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        if (root != null) st.push(root);

        while (!st.isEmpty()){
            TreeNode node = st.peek();
            if (node != null){
                st.pop();// 将该节点弹出，避免重复操作，下面再将右中左节点添加到栈中

                // 前序
                if (node.right != null) st.push(node.right);// 添加右节点（空节点不入栈）
                if (node.left != null) st.push(node.left);// 添加左节点（空节点不入栈）
                st.push(node);
                st.push(null);// 中节点访问过，但是还没有处理，加入空节点做为标记。

//                // 中序
//                if (node.right != null) st.push(node.right);// 添加右节点（空节点不入栈）
//                st.push(node);
//                st.push(null);// 中节点访问过，但是还没有处理，加入空节点做为标记。
//                if (node.left != null) st.push(node.left);// 添加左节点（空节点不入栈）

//                // 后序
//                st.push(node);
//                st.push(null);// 中节点访问过，但是还没有处理，加入空节点做为标记。
//                if (node.right != null) st.push(node.right);// 添加右节点（空节点不入栈）
//                if (node.left != null) st.push(node.left);// 添加左节点（空节点不入栈）

            }else {// 只有遇到空节点的时候，才将下一个节点放进结果集
                st.pop();// 将空节点弹出
                node = st.peek();// 重新取出栈中元素
                st.pop();
                res.add(node.val);// 加入到结果集
            }
        }
        return res;
    }

}
