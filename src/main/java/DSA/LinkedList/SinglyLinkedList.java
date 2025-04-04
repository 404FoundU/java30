package DSA.LinkedList;


public class SinglyLinkedList {
    private static class Node {
        private final int val;
        private Node next;

        public Node(int val) {
            this.val = val;
            this.next = null;
        }
    }
    private Node head;
    private Node tail;
    private int length;


    private void pushTo(int value) {
        Node node = new Node(value);
        if (this.head == null) {
            this.head = node;
            this.tail = node;

        } else {
            this.tail.next = node;
            this.tail = node;
        }
        this.length++;
    }

    private void pop() {
        if (this.head == null) {
           return;

        }
        Node current = this.head;
        Node previous= this.head;
        while (current.next != null) {
            previous = current;
            current = current.next;
        }
        this.tail = previous;
        this.tail.next = null;

        this.length--;
        System.out.println("pop " + current.val);
    }

    private void insertFirst(int value) {
        Node node = new Node(value);
        if (this.head == null) {
            this.head = node;
            this.tail = node;

        } else {
            Node current = this.head;
            node.next = current;
            this.head = node;
        }
        this.length++;
    }

    private void deleteFirst() {
        if (this.head == null) {
           return;

        }
            Node current = this.head;
            this.head = this.head.next;
            current.next = null;

        this.length--;
    }

    private void insertAt(int value, int position) {

        if (position > this.length) {
            pushTo(value);
            return;
        }
        if (position == 1 || this.length == 0) {
            insertFirst(value);
            return;
        }

        Node node = new Node(value);
        Node current = this.head;
        Node previous;
        int count = 1;
        while (current.next != null) {
            previous = current;
            current = current.next;
            count++;
            if (count == position) {
                node.next = current;
                previous.next = node;
                break;
            }

        }

        this.length++;
    }
    private void deleteAt(int position) {

        if (position > this.length|| this.length == 0) {
            return;
        }
        if (position == 1 ) {
            deleteFirst();
            return;
        }

        Node current = this.head;
        Node previous;
        Node nextNode;
        int count = 1;
        while (current.next != null) {
            previous = current;
            current = current.next;
            nextNode = current.next;
            count++;
            if (count == position) {
                current.next = null;
                previous.next = nextNode;
                break;
            }


        }

        this.length--;
    }


    private void printList() {
        Node current = this.head;
        while (current.next != null) {
            System.out.println(current.val);
            current = current.next;
        }
        System.out.println(current.val);

    }

    public static void main(String[] args) {
        SinglyLinkedList ll = new SinglyLinkedList();
        ll.pushTo(5);
        ll.pushTo(6);
        ll.pushTo(7);
        ll.pushTo(1);
        ll.pushTo(2);
        ll.pushTo(3);
//        ll.insertFirst(8);
//        ll.insertAt(9, 2);
//        ll.deleteFirst();
//        ll.pop();
//        ll.deleteAt( 3);
        ll.printList();

        ll.printList();
    }
}
