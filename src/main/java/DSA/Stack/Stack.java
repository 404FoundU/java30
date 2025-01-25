package DSA.Stack;


import java.util.EmptyStackException;

public class Stack {

    private static class Node {
        private final int data;
        private Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node top;
    private int length;

    public Stack() {
        this.top = null;
        this.length = 0;
    }

    public boolean isEmpty() {
        return this.length == 0;
    }

    private void push(int value) {
        Node temp = new Node(value);
        if (this.top != null) {
            temp.next = this.top;
        }
        this.top = temp;

        this.length++;
    }

    private int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        int result = this.top.data;
        this.top = this.top.next;
        this.length--;
        return result;
    }

    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return this.top.data;
    }


    private void printStack() {
        Node current = this.top;
        while (current.next != null) {
            System.out.println(current.data);
            current = current.next;
        }
        System.out.println(current.data);
    }

    public static void main(String[] args) {
        Stack ll = new Stack();

        ll.push(1);
        ll.push(2);
        ll.push(3);
        ll.push(5);
        ll.push(6);
        ll.push(7);
        ll.printStack();


        System.out.println("pop: "+ ll.pop());

        ll.printStack();

    }
}
