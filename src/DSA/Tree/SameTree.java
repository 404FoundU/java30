package DSA.Tree;

//https://www.youtube.com/watch?v=jK6XXYezw2g&list=PLKYEe2WisBTH48RzVCL_LQrGW-ahPY44S&index=5
public class SameTree {

    public boolean isSameTree(BinaryNode p, BinaryNode q) {
        // Base case: both nodes are null
        if (p == null && q == null) {
            return true;
        }

        // If one is null and the other is not, they are not the same
        if (p == null || q == null) {
            return false;
        }

        if (!p.val.equals(q.val)) {
            return false;
        }

        // and recursively check their children
        boolean sameTreeLeft = isSameTree(p.left, q.left);
        boolean sameTreeRight = isSameTree(p.right, q.right);

        return sameTreeLeft && sameTreeRight;
    }

    public static void main(String[] args) {
        BinaryNode root1 = new BinaryNode();
        root1.val = "1";
        root1.left = new BinaryNode();
        root1.left.val = "2";
        root1.right = new BinaryNode();
        root1.right.val = "3";

        BinaryNode root2 = new BinaryNode();
        root2.val = "1";
        root2.left = new BinaryNode();
        root2.left.val = "2";
        root2.right = new BinaryNode();
        root2.right.val = "3";

        SameTree checker = new SameTree();
        System.out.println("Are the trees the same? " + checker.isSameTree(root1, root2)); // Output: true
    }
}

