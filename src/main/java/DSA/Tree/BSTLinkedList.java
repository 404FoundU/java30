package DSA.Tree;


public class BSTLinkedList {
    private class Node {
        private final int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    private Node root;


    public static void main(String[] args) {
        BSTLinkedList bst = new BSTLinkedList();
        System.out.println(bst.root);

        bst.insert(10);
        System.out.println(bst.root.data);
        bst.insert(17);
        bst.insert(4);
        bst.insert(6);
        bst.insert(5);
        bst.insert(2);
        bst.insert(8);
        bst.insert(20);
        bst.insert(18);
        System.out.println(bst.contains(20));
        System.out.println(bst.contains(3));


    }

    private void insert(int data) {
        Node node = new Node(data);
        if (this.root == null) {
            this.root = node;
            return;
        }
        Node current = this.root;
        while (current != null) {
            if (current.data > data) {
                if (current.left == null) {
                    current.left = node;
                    break;
                }
                current = current.left;
            }
            if (current.data < data) {
                if (current.right == null) {
                    current.right = node;
                    break;
                }
                current = current.right;
            }
        }
    }

    public boolean contains(int data) {
        Node current = this.root;
        while (current != null) {
            if (data < current.data) {
                current = current.left;

            } else if (data > current.data) {
                current = current.right;
            } else {
                return true;
            }
        }
        return false;

    }

    public void preOrderTraversal() {
        Node current = this.root;
        while (current != null) {
            System.out.println(current.data);
            if (current.left != null) {
                current = current.left;
            } else if (current.right != null) {
                current = current.right;
            }
        }
    }


}
