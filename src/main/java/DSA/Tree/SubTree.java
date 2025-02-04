package DSA.Tree;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/subtree-of-another-tree/description/
public class SubTree {

    public boolean subTree(BinaryNode t1, BinaryNode t2) {

        Queue<BinaryNode> q = new LinkedList<>();
        q.add(t1);
        while (!q.isEmpty()) {
            BinaryNode current = q.poll();
            if (current.val.equals(t2.val)) {
                return same(current, t2);
            }
            if (current.left != null) {
                q.add(current.left);
            }
            if (current.right != null) {
                q.add(current.right);
            }
        }
        return false;
    }

    boolean same(BinaryNode root1, BinaryNode root2) {

        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 == null || root2 == null) {
            return false;
        }

        if (!root1.val.equals(root2.val)) {
            return false;
        }
        boolean sameLeft = same(root1.left, root2.left);
        boolean sameRight = same(root1.right, root2.right);
        return sameLeft && sameRight;
    }

    public static void main(String[] args) {
        BinaryNode root = new BinaryNode();
        root.val = "3";
        root.left = new BinaryNode();
        root.left.val = "4";
        root.right = new BinaryNode();
        root.right.val = "5";
        root.left.left = new BinaryNode();
        root.left.left.val = "1";
        root.right.right = new BinaryNode();
        root.right.right.val = "2";

        BinaryNode root2 = new BinaryNode();
        root.val = "4";
        root.left = new BinaryNode();
        root.left.val = "1";
        root.right = new BinaryNode();
        root.right.val = "2";

        SubTree checker = new SubTree();
        System.out.println("subtree " + checker.subTree(root, root2)); // Output: true


    }
}

