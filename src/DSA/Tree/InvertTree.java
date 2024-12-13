package DSA.Tree;


import java.util.LinkedList;
import java.util.Queue;

public class InvertTree {

    public void invert(TreeNode root) {

    }

    public static void main(String[] args) {
        InvertTree solution = new InvertTree();

        // Creating a linked list: 1 -> 2 -> 3 -> 4 -> 5
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        System.out.print("Original Tree: ");
        printTree(root);

        // Reversing the linked list recursively
        solution.invert(root);

        System.out.print(" Update Tree): ");
        printTree(root);
    }

    private static void printTree(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode current = q.poll();
            System.out.print(current.val + "->");
            if (current.left != null) {
                q.add(current.left);
            }
            if (current.right != null) {
                q.add(current.right);
            }
        }
    }
}
