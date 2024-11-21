package DSA.Tree;

//https://www.youtube.com/watch?v=BooilJIjNHc&list=PLKYEe2WisBTH48RzVCL_LQrGW-ahPY44S&index=6
public class SymmetricTree {

    public boolean symmetric(BinaryNode root) {
        BinaryNode root1 = root.left;
        BinaryNode root2 = root.right;
        return same(root1, root2);
    }

    boolean same(BinaryNode root1, BinaryNode root2) {

        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 == null || root2 == null) {
            return false;
        }

        if (!root1.data.equals(root2.data)) {
            return false;
        }
        boolean sameLeft = same(root1.left, root2.right);
        boolean sameRight = same(root1.right, root2.left);
        return sameLeft && sameRight;
    }

    public static void main(String[] args) {
        BinaryNode root = new BinaryNode();
        root.data = "1";
        root.left = new BinaryNode();
        root.left.data = "2";
        root.right = new BinaryNode();
        root.right.data = "3";


        SymmetricTree checker = new SymmetricTree();
        System.out.println("Are the trees symmetric? " + checker.symmetric(root)); // Output: true


    }
}

