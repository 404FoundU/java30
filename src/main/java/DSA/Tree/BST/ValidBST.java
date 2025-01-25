package DSA.Tree.BST;

import DSA.Tree.TreeNode;

import java.util.Stack;

//https://www.youtube.com/watch?v=92zdLCeiumk&list=PLKYEe2WisBTH48RzVCL_LQrGW-ahPY44S&index=11

/*
BST has max at right and min on left.
So we need to track the min and max value locally.
BTwithMinMax
 */
public class ValidBST {
    public boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isValidBSTHelper(TreeNode current, int minValue, int maxValue) {
        if (current == null) {
            return true;
        }
        if (current.val > minValue && current.val < maxValue) {
            return false;
        }


        isValidBSTHelper(current, minValue, current.val);
        isValidBSTHelper(current, current.val, maxValue);
        return false;
    }

    public boolean isValidBSTIter(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        Integer prev = null;

        while (current != null || !stack.isEmpty()) {
            // Traverse to the leftmost node
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            // Process the current node
            current = stack.pop();
            if (prev != null && current.val <= prev) {
                return false; // Not strictly increasing
            }
            prev = current.val; // Update prev value

            // Move to the right subtree
            current = current.right;
        }

        return true; // If no violations are found
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        ValidBST solution = new ValidBST();
        boolean valid = solution.isValidBST(root);
        System.out.println("isValidBST: " + valid);
    }
}
