package DSA.Tree;
//https://www.youtube.com/watch?v=6lJZ_xj1mEo&list=PLKYEe2WisBTH48RzVCL_LQrGW-ahPY44S&index=4


public class Diameter {

    // Static variable to store the maximum diameter
    private int maxDiameter = 0;

    public int diameter(BinaryNode root) {
        // Reset maxDiameter for each new tree calculation
        maxHeightHelper(root);
        return maxDiameter;
    }

    private int maxHeightHelper(BinaryNode root) {
        if (root == null) {
            return 0; // Height of an empty subtree is 0
        }

        // Recursively get the height of the left and right subtrees
        int leftHeight = maxHeightHelper(root.left);
        int rightHeight = maxHeightHelper(root.right);

        // Update the maximum diameter found so far
        maxDiameter = Math.max(maxDiameter, leftHeight + rightHeight);

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

        Diameter treeDiameter = new Diameter();
        System.out.println("Diameter of the tree: " + treeDiameter.diameter(root)); // Expected Output: 3
    }
}

