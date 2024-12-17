package DSA.Tree;

/*



4. How would you design an algorithm to serialize and deserialize a binary tree?

5. How would you find the maximum path sum in a binary tree, where the path can start and end at any node?


7. Given a node in a BST, how would you find its in-order successor without using additional space?


9. How would you construct a binary tree from its preorder and inorder traversal sequences?

10. How can you flatten a binary tree to a linked list in-place following the pre-order traversal order?


12. How can you determine if there is a root-to-leaf path in a binary tree that adds up to a given target sum?

13. How would you perform a zigzag (spiral) level order traversal of a binary tree?


15. How can you convert a sorted array into a height-balanced binary search tree?

16. How would you return the rightmost elements that are visible from the right side of a binary tree?


18. How would you delete a node with a given key in a binary search tree?


20. Given a binary tree and a target node, how would you find all nodes at a distance K from the target node?



 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static void printTreeBfs(TreeNode root) {//NLR
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

    public static void printTreeDfsPreOrder(TreeNode root) {//NLLR
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            System.out.print(current.val + "->");
            // Push right child first so left child is processed first
            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
        }
    }

    public static void printTreeDfsPostorder(TreeNode root) { // LRNLRN
        if (root == null) return;
//Stack 1 is for traversal, and stack 2 is for storing nodes.
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty()) {
            TreeNode current = stack1.pop();
            // push popped nodes instead of print
            stack2.push(current);
            //  reverse order of preorder traversal
            if (current.left != null) {
                stack1.push(current.left);
            }
            if (current.right != null) {
                stack1.push(current.right);
            }
        }
        // Print from the second stack
        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().val + " -> ");
        }
        System.out.println("null");
    }

    // print left most subtree
    public static void printTreeDfsInOrder(TreeNode root) {//LNRLNR
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            // keep pushing to bottom tree on left
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            System.out.print(current.val + "->");
            //push all right trees of the ones in stack
            current = current.right;
        }
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        /*
        4
       / \
      2   7
     / \ / \
    1  3 6  9
         */
        printTreeBfs(root);
        System.out.println("Original Tree BFS: ");

        printTreeDfsPreOrder(root);
        System.out.println("Original Tree DFS Preorder: ");

        printTreeDfsInOrder(root);
        System.out.println("Original Tree DFS Inorder: ");
        printTreeDfsPostorder(root);
        System.out.println("Original Tree DFS postOrder: ");


        System.out.println(" Update Tree): ");
        printTreeBfs(root);
    }
}
