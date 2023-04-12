package BinaryTree;

import LinkedList.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 递归遍历二叉树
 */

public class RecursiveTraversal {

    // 前序递归遍历
    public List<Integer> solution1(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        preorder(root,ans);
        return ans;
    }
    public void preorder(TreeNode root,List<Integer> ans){
        if (root == null){
            return;
        }
        ans.add(root.val);
        preorder(root.left,ans);
        preorder(root.right,ans);
    }

    // 中序递归遍历
    public List<Integer> solution2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inorder(root,ans);
        return ans;
    }
    public void inorder(TreeNode root,List<Integer> ans){
        if (root == null){
            return;
        }
        inorder(root.left,ans);
        ans.add(root.val);
        inorder(root.right,ans);
    }

    // 后序递归遍历
    public List<Integer> solution3(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        postorder(root,ans);
        return ans;
    }
    public void postorder(TreeNode root,List<Integer> ans){
        if (root == null){
            return;
        }
        postorder(root.left,ans);
        postorder(root.right,ans);
        ans.add(root.val);
    }
}
