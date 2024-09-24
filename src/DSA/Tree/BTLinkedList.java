package DSA.Tree;


import java.util.LinkedList;
import java.util.Queue;

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
        n1.data = "N1";
        n2.data = "N2";
        n3.data = "N3";
        n4.data = "N4";
        n5.data = "N5";
        n6.data = "N6";
        n7.data = "N7";
        n8.data = "N8";
        n9.data = "N9";
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
    }


    public void preOrderTraversal(BinaryNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.data + " ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    public void inOrderTraversal(BinaryNode node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left);
        System.out.println(node.data + " ");
        inOrderTraversal(node.right);
    }

    public void postOrderTraversal(BinaryNode node) {
        if (node == null) {
            return;
        }
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.println(node.data + " ");

    }

    void levelOrderTraversal() {
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryNode firstNode = queue.remove();
            System.out.println(firstNode.data + " ");
            if (firstNode.left != null) {
                queue.add(firstNode.left);
            }
            if (firstNode.right != null) {
                queue.add(firstNode.right);
            }
        }
    }

    void insert(String data) {
        BinaryNode node = new BinaryNode();
        node.data = data;
        Queue<BinaryNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            BinaryNode firstNode = q.remove();
            if (firstNode.left != null) {
                firstNode.left = node;
                System.out.println("inserted left child at " + firstNode.data);
                break;
            } else if (firstNode.right != null) {
                firstNode.right = node;
                System.out.println("inserted right child at " + firstNode.data);
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
