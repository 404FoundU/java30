package DSA.Tree.BST;


import DSA.Tree.TreeNode;

/*
check which direction to go.
If both values are less than current node go left.
If both values > current node go right
 */
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Traverse the tree
        while (root != null) {
            if (p.val < root.val && q.val < root.val) {
                // Both nodes are in the left subtree
                root = root.left;
            } else if (p.val > root.val && q.val > root.val) {
                // Both nodes are in the right subtree
                root = root.right;
            } else {
                // Current root is the LCA
                return root;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        // Example BST
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        TreeNode p = root.left;          // Node with value 2
        TreeNode q = root.right;         // Node with value 8

        LowestCommonAncestor solution = new LowestCommonAncestor();
        TreeNode lca = solution.lowestCommonAncestor(root, p, q);

        System.out.println("Lowest Common Ancestor: " + lca.val); // Output: 6
    }
}
