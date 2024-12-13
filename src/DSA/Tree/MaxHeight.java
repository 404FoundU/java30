package DSA.Tree;
//https://www.youtube.com/watch?v=ScvTcU2Aifs&list=PLKYEe2WisBTH48RzVCL_LQrGW-ahPY44S&index=2


import static DSA.Tree.TreeNode.printTreeBfs;

public class MaxHeight {


    public int maxHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = maxHeight(root.left);
        int rightHeight = maxHeight(root.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        MaxHeight solution = new MaxHeight();
        System.out.print("Original tree (in-order traversal): ");
        printTreeBfs(root);
        System.out.println();
        int height = solution.maxHeight(root);
        System.out.println("height = " + height);

    }
}






