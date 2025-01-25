package DSA.Tree;
//https://www.youtube.com/watch?v=6lJZ_xj1mEo&list=PLKYEe2WisBTH48RzVCL_LQrGW-ahPY44S&index=4
/*


3. Given two nodes in a binary tree, how would you find their lowest common ancestor?

4. How would you design an algorithm to serialize and deserialize a binary tree?

5. How would you find the maximum path sum in a binary tree, where the path can start and end at any node?

6. How would you determine if a binary tree is symmetric (a mirror of itself) around its center?

7. Given a node in a BST, how would you find its in-order successor without using additional space?


9. How would you construct a binary tree from its preorder and inorder traversal sequences?

10. How can you flatten a binary tree to a linked list in-place following the pre-order traversal order?

11. How would you check if a binary tree is a valid binary search tree (BST)?

12. How can you determine if there is a root-to-leaf path in a binary tree that adds up to a given target sum?

13. How would you perform a zigzag (spiral) level order traversal of a binary tree?

14. How would you find the k-th smallest element in a binary search tree?

15. How can you convert a sorted array into a height-balanced binary search tree?

16. How would you return the rightmost elements that are visible from the right side of a binary tree?

17. How would you count the number of “good” nodes in a binary tree, where a node is considered “good” if its value is at least as large as any other node value from the root to that node?

18. How would you delete a node with a given key in a binary search tree?

19. How would you design an iterator over a BST that iterates nodes in sorted order with O(h) space complexity, where h is the height of the tree?

20. Given a binary tree and a target node, how would you find all nodes at a distance K from the target node?



 */

public class Balanced {

    // Static variable to store the maximum diameter
    private boolean balanced = true;

    public boolean balanced(BinaryNode root) {
        // Reset balanced for each new tree calculation
        balanced = true;
        maxHeightHelper(root);
        return balanced;
    }

    private int maxHeightHelper(BinaryNode root) {
        if (root == null) {
            return 0; // Height of an empty subtree is 0
        }

        // Recursively get the height of the left and right subtrees
        int leftHeight = maxHeightHelper(root.left);
        int rightHeight = maxHeightHelper(root.right);

        if (Math.abs(leftHeight - rightHeight) > 1) {
            balanced = false;
            return 0;
        }

        // Return the height of the current node
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        // Example to test the code
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

        Balanced treeDiameter = new Balanced();
        System.out.println("Balanced: " + treeDiameter.balanced(root));
    }
}

