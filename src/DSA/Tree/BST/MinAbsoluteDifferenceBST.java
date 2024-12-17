package DSA.Tree.BST;

import DSA.Tree.TreeNode;

import java.util.Stack;

//https://www.youtube.com/watch?v=92zdLCeiumk&list=PLKYEe2WisBTH48RzVCL_LQrGW-ahPY44S&index=11

/*
family tree of 8 people. Dad at the top
Dad wants everything in order. Inorder will be sorted.
Dad is standing previous to mom. Mom is standing previous to son
 */
public class MinAbsoluteDifferenceBST {
    public int minAbsDiff(TreeNode root) {
        if (root == null) {
            return -1;
        }
        //Inorder traversal for BST
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        TreeNode current = root;
        int minDifference = Integer.MAX_VALUE;
        TreeNode previous = null;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);

                current = current.left;
            }
            current = stack.pop();
            if (previous != null) {
                minDifference = Math.max(minDifference, Math.abs(current.val - previous.val));
            }

            previous = current;
            current = current.right;
        }
        return minDifference;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        MinAbsoluteDifferenceBST solution = new MinAbsoluteDifferenceBST();
        int minAbsDiff = solution.minAbsDiff(root);
        System.out.println("minAbsDiff: " + minAbsDiff);
    }
}
