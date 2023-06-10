package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 判断满二叉树中是否存在 左右子树权值相等的结点
 */

public class EqualWeights {

    public static void solution(){
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0 && scanner.hasNext()){
            String s = scanner.nextLine();

            s.trim();
            String[] s1 = s.split(" ");
            int[] nums = new int[s1.length];

            for (int i = 0; i < s1.length; i++) {
                nums[i] = Integer.parseInt(s1[i]);
            }

            TreeNode root = build(nums);

            boolean res = solution(root);

            if (res){
                System.out.println("Yes");
            }else {
                System.out.println("No");
            }
        }
    }

    //根据数组建满二叉树
    public static TreeNode build(int[] nums){
        if (nums == null || nums.length == 0){
            return null;
        }
        TreeNode root = new TreeNode(nums[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (i < nums.length){
            TreeNode node = queue.poll();
            int leftVal = nums[i++];
            int rightVal =nums[i++];

            node.left = new TreeNode(leftVal);
            queue.offer(node.left);

            node.right = new TreeNode(rightVal);
            queue.offer(node.right);
        }
        return root;
    }

    //递归判断是否存在这样的结点
    public static boolean solution(TreeNode root){
        if (root == null){
            return false;
        }
        if (root.left == null) return false;
        int leftSum = getSum(root.left);
        int rightSum = getSum(root.right);
        return (leftSum == rightSum) || solution(root.left) || solution(root.right);
    }

    //计算结点的左右权值
    public static int getSum(TreeNode node){
        if (node == null){
            return 0;
        }
        return node.val + getSum(node.left) + getSum(node.right);
    }

    public static void main(String[] args) {
        solution();
    }
}

/**
 *
 *
 *      1
 *    2   2
 *  1  2  1  2
 *
 *
 *
 *
 */