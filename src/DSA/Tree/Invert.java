package DSA.Tree;
//https://www.youtube.com/watch?v=6lJZ_xj1mEo&list=PLKYEe2WisBTH48RzVCL_LQrGW-ahPY44S&index=4

import java.util.LinkedList;
import java.util.Queue;

public class Invert {


    public BinaryNode invertTree(BinaryNode root) {
        if (root == null) {
            return null;
        }

        BinaryNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public BinaryNode invertTreeBfs(BinaryNode root) {
        if (root == null) {
            return null;
        }

        Queue<BinaryNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            BinaryNode current = queue.poll();

            // Swap the left and right children
            BinaryNode temp = current.left;
            current.left = current.right;
            current.right = temp;

            // Add children to the queue for further processing
            if (current.left != null) queue.offer(current.left);
            if (current.right != null) queue.offer(current.right);
        }

        return root;
    }

    public void printTree(BinaryNode node) {
        if (node == null) {
            return;
        }
        printTree(node.left);
        System.out.print(node.val + " ");
        printTree(node.right);
    }

    public static void main(String[] args) {
        // Creating a sample binary tree
        BinaryNode root = new BinaryNode();
        root.val = "1";
        root.left = new BinaryNode();
        root.left.val = "2";

        root.right = new BinaryNode();
        root.right.val = "3";

        root.left.left = new BinaryNode();
        root.left.left.val = "4";

        root.left.right = new BinaryNode();
        root.left.right.val = "5";

        root.right.left = new BinaryNode();
        root.right.left.val = "6";

        root.right.right = new BinaryNode();
        root.right.right.val = "7";

        // Print the original tree
        Invert treeInverter = new Invert();
        System.out.print("Original tree (in-order traversal): ");
        treeInverter.printTree(root);
        System.out.println();

        // Invert the tree
        treeInverter.invertTree(root);

        // Print the inverted tree
        System.out.print("Inverted tree (in-order traversal): ");
        treeInverter.printTree(root);
        System.out.println();
    }
}






