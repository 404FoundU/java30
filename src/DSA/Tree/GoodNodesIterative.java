package DSA.Tree;


import java.util.Stack;


public class GoodNodesIterative {

    public int goodNodes(BinaryNode root) {
        if (root == null) {
            return 0;
        }

        // Stack to hold pairs of (node, maxVal so far)
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, Integer.parseInt(root.val)));

        int count = 0;

        // Perform DFS using the stack
        while (!stack.isEmpty()) {
            Pair current = stack.pop();
            BinaryNode node = current.node;
            int maxVal = current.maxVal;

            int currentVal = Integer.parseInt(node.val);

            // Check if the current node is a good node
            if (currentVal >= maxVal) {
                count++;
            }

            // Update maxVal for child nodes
            maxVal = Math.max(maxVal, currentVal);

            // Add left and right children to the stack (if they exist)
            if (node.left != null) {
                stack.push(new Pair(node.left, maxVal));
            }
            if (node.right != null) {
                stack.push(new Pair(node.right, maxVal));
            }
        }

        return count;
    }

    // Helper class to store node and maxVal as a pair
    static class Pair {
        BinaryNode node;
        int maxVal;

        Pair(BinaryNode node, int maxVal) {
            this.node = node;
            this.maxVal = maxVal;
        }
    }

    public static void main(String[] args) {
        // Tree 1
        BinaryNode root = new BinaryNode();
        root.val = "3";
        root.left = new BinaryNode();
        root.left.val = "1";
        root.right = new BinaryNode();
        root.right.val = "4";
        root.left.left = new BinaryNode();
        root.left.left.val = "3";
        root.right.right = new BinaryNode();
        root.right.right.val = "5";
        root.right.left = new BinaryNode();
        root.right.left.val = "1";

        // Tree 2
        BinaryNode root2 = new BinaryNode();
        root2.val = "3";
        root2.left = new BinaryNode();
        root2.left.val = "3";
        root2.left.left = new BinaryNode();
        root2.left.left.val = "4";
        root2.left.right = new BinaryNode();
        root2.left.right.val = "2";

        GoodNodesIterative checker = new GoodNodesIterative();
        System.out.println("Good nodes in Tree 1: " + checker.goodNodes(root));  // Output: 4
        System.out.println("Good nodes in Tree 2: " + checker.goodNodes(root2)); // Output: 3
    }
}

