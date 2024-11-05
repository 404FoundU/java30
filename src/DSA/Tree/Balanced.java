package DSA.Tree;
//https://www.youtube.com/watch?v=6lJZ_xj1mEo&list=PLKYEe2WisBTH48RzVCL_LQrGW-ahPY44S&index=4


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
        root.data = "1";
        root.left = new BinaryNode();
        root.left.data = "2";
        root.right = new BinaryNode();
        root.right.data = "3";
        root.left.left = new BinaryNode();
        root.left.left.data = "4";
        root.left.right = new BinaryNode();
        root.left.right.data = "5";

        Balanced treeDiameter = new Balanced();
        System.out.println("Balanced: " + treeDiameter.balanced(root));
    }
}

