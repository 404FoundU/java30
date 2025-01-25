package DSA.Tree.BST;

import DSA.Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//https://www.youtube.com/watch?v=92zdLCeiumk&list=PLKYEe2WisBTH48RzVCL_LQrGW-ahPY44S&index=11

/*
family tree of 8 people. Dad at the top
Dad wants everything in order. Inorder will be sorted
 */
public class KthSmallestElementBST {
    public int kSmallestElement(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }
        //Inorder traversal for BST
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        TreeNode current = root;
        List<Integer> result = new ArrayList<>();

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            result.add(current.val);
            current = current.right;
        }
        return result.get(k - 1);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        KthSmallestElementBST solution = new KthSmallestElementBST();
        int smallest = solution.kSmallestElement(root, 3);
        System.out.println("smallest: " + smallest);
    }
}
