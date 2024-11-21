package DSA.Tree;

//https://www.youtube.com/watch?v=2AdOBLcj2wk&list=PLKYEe2WisBTH48RzVCL_LQrGW-ahPY44S&index=8
public class GoodNodesRecursive {

    public int goodNodes(BinaryNode root) {
        return dfsGoodNodes(root, Integer.MIN_VALUE);

    }

    private int dfsGoodNodes(BinaryNode root, int maxVal) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        int currentVal = Integer.parseInt(root.val);
        if (currentVal >= maxVal) {
            count = 1;
        }
        maxVal = Math.max(currentVal, maxVal);

        count = count + dfsGoodNodes(root.left, maxVal);
        count = count + dfsGoodNodes(root.right, maxVal);

        return count;
    }


    public static void main(String[] args) {
        BinaryNode root = new BinaryNode();
        root.val = "3";
        root.left = new BinaryNode();
        root.left.val = "1";
        root.right = new BinaryNode();
        root.right.val = "4";
        root.left.left = new BinaryNode();
        root.left.left.val = "3";
        root.right.right = new BinaryNode();
        root.right.right.val = "5";
        root.right.left = new BinaryNode();
        root.right.left.val = "1";

        BinaryNode root2 = new BinaryNode();
        root2.val = "3";
        root2.left = new BinaryNode();
        root2.left.val = "3";
        root2.left.left = new BinaryNode();
        root2.left.left.val = "4";
        root2.left.right = new BinaryNode();
        root2.left.right.val = "2";

        GoodNodesRecursive checker = new GoodNodesRecursive();
        System.out.println("good node " + checker.goodNodes(root)); // Output: 4
//        System.out.println("good node " + checker.goodNodes(root2)); // Output: 3


    }
}

