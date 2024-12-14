package DSA.Tree;
//https://www.youtube.com/watch?v=ScvTcU2Aifs&list=PLKYEe2WisBTH48RzVCL_LQrGW-ahPY44S&index=2


public class PathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        // Base case: If the tree is empty, there can be no path
        if (root == null) {
            return false;
        }

        // Check if we're at a leaf node
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }

        // Recursively check left and right subtrees with the reduced target sum
        int remainingSum = targetSum - root.val;
        return hasPathSum(root.left, remainingSum) || hasPathSum(root.right, remainingSum);
    }

    int targetSum;

    public boolean pathSum(TreeNode root, int target) {
        targetSum = target;
        return pathSumHelper(root, 0);
    }

    private boolean pathSumHelper(TreeNode root, int currentSum) {

        if (root == null) {
            return false;
        }
        currentSum += root.val;
        //leaf node
        if (root.left == null && root.right == null) {
            return currentSum == targetSum;
        }
        return pathSumHelper(root.left, currentSum) || pathSumHelper(root.right, currentSum);
    }

    // Main method for testing
    public static void main(String[] args) {
        // Constructing the tree:
        /*
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
        */
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.right = new TreeNode(1);

        PathSum solution = new PathSum();

        // Test Case 1
        int targetSum1 = 22;
        System.out.println("Has Path Sum for target " + targetSum1 + ": " + solution.hasPathSum(root, targetSum1)); // Expected: true

        // Test Case 2
        int targetSum2 = 26;
        System.out.println("Has Path Sum for target " + targetSum2 + ": " + solution.hasPathSum(root, targetSum2)); // Expected: true

        // Test Case 3
        int targetSum3 = 18;
        System.out.println("Has Path Sum for target " + targetSum3 + ": " + solution.hasPathSum(root, targetSum3)); // Expected: false
    }
}







