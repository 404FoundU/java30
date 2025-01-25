package DSA.Tree;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BTLinkedList {


    private BinaryNode root;

    public BTLinkedList() {
        this.root = null;
    }

    public static void main(String[] args) {
        BTLinkedList bt = new BTLinkedList();
        BinaryNode n1 = new BinaryNode();
        BinaryNode n2 = new BinaryNode();
        BinaryNode n3 = new BinaryNode();
        BinaryNode n4 = new BinaryNode();
        BinaryNode n5 = new BinaryNode();
        BinaryNode n6 = new BinaryNode();
        BinaryNode n7 = new BinaryNode();
        BinaryNode n8 = new BinaryNode();
        BinaryNode n9 = new BinaryNode();
        n1.val = "N1";
        n2.val = "N2";
        n3.val = "N3";
        n4.val = "N4";
        n5.val = "N5";
        n6.val = "N6";
        n7.val = "N7";
        n8.val = "N8";
        n9.val = "N9";
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        n4.left = n8;
        n4.right = n9;

        bt.root = n1;
        bt.preOrderTraversal(bt.root);
        bt.dfsStack();
        System.out.println(bt.maxHeight());
    }


    public void preOrderTraversal(BinaryNode node) { // OLR DFS
        if (node == null) {
            return;
        }
        System.out.println(node.val + " ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    public void inOrderTraversal(BinaryNode node) { // LOR
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left);
        System.out.println(node.val + " ");
        inOrderTraversal(node.right);
    }

    public void postOrderTraversal(BinaryNode node) { // LR0
        if (node == null) {
            return;
        }
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.println(node.val + " ");

    }

    public void inOrderStack() {
        Stack<BinaryNode> stack = new Stack<>();
        BinaryNode current = root;

        while (current != null || !stack.isEmpty()) {
            // reach the left most node
            while (current != null) {
                stack.push(current); // Place pointer to the tree node on the stack
                current = current.left;
            }
            // Current must be null at this point, so we pop the top node from the stack
            current = stack.pop();
            System.out.println(current.val + " ");

            // traverse right subtree
            current = current.right;
        }

    }

    void levelOrderTraversal() { // BFS
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryNode firstNode = queue.remove();
            System.out.println(firstNode.val + " ");
            if (firstNode.left != null) {
                queue.add(firstNode.left);
            }
            if (firstNode.right != null) {
                queue.add(firstNode.right);
            }
        }
    }

    void dfsStack() {
        System.out.println("dfs");
        Stack<BinaryNode> stack = new Stack<>();
        stack.push(this.root);
        while (!stack.isEmpty()) {
            BinaryNode currentNode = stack.pop();
            System.out.println(" " + currentNode.val);
            if (currentNode.right != null) {
                stack.push(currentNode.right);
            }
            if (currentNode.left != null) {
                stack.push(currentNode.left);
            }
        }
    }

    int maxHeight() {
        Stack<BinaryNode> stack = new Stack<>();
        stack.add(root);
        Stack<Integer> depthStack = new Stack<>();
        depthStack.push(1);
        int maxDepth = 0;
        while (!stack.isEmpty()) {
            BinaryNode currentNode = stack.pop();
            Integer depth = depthStack.pop();
            maxDepth = Math.max(maxDepth, depth);
            if (currentNode.right != null) {
                stack.push(currentNode.right);
                depthStack.push(depth + 1);
            }
            if (currentNode.left != null) {
                stack.push(currentNode.left);
                depthStack.push(depth + 1);

            }
        }
        return maxDepth;
    }

    int maxHeightDfs(BinaryNode current) {
        if (current == null) {
            return 0;
        }
        int leftDepth = maxHeightDfs(current.left);

        int rightDepth = maxHeightDfs(current.right);

        return Math.max(leftDepth, rightDepth) + 1;

    }




    void insert(String data) {
        BinaryNode node = new BinaryNode();
        node.val = data;
        Queue<BinaryNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            BinaryNode firstNode = q.remove();
            if (firstNode.left != null) {
                firstNode.left = node;
                System.out.println("inserted left child at " + firstNode.val);
                break;
            } else if (firstNode.right != null) {
                firstNode.right = node;
                System.out.println("inserted right child at " + firstNode.val);
                break;
            }
            if (firstNode.left != null) {
                q.add(firstNode.left);
            }
            if (firstNode.right != null) {
                q.add(firstNode.right);
            }
        }
    }

// delete node
    // https://www.udemy.com/course/java-data-structures-and-algorithms-masterclass/learn/lecture/24644378#overview
}
