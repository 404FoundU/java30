package DSA.Tree;


import static DSA.Tree.TreeNode.printTreeBfs;
import static DSA.Tree.TreeNode.printTreeDfsInOrder;
import static DSA.Tree.TreeNode.printTreeDfsPreOrder;

public class InvertTree {

    public void invert(TreeNode root) {


    }

    public static void main(String[] args) {
        InvertTree solution = new InvertTree();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        printTreeBfs(root);
        System.out.println("Original Tree BFS: ");

        printTreeDfsPreOrder(root);
        System.out.println("Original Tree DFS Preorder: ");

        printTreeDfsInOrder(root);
        System.out.println("Original Tree DFS Inorder: ");

        solution.invert(root);

        System.out.println(" Update Tree): ");
        printTreeBfs(root);
    }


}
