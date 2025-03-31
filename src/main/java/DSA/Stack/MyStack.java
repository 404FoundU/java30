package DSA.Stack;


import java.util.EmptyStackException;

public class MyStack<T> {

    private class StackNode {
        private final T data;
        private StackNode next;

        public StackNode(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private StackNode top;
    private int length;

    public MyStack() {
        this.top = null;
        this.length = 0;
    }

    public boolean isEmpty() {
        return this.length == 0;
    }

    public void push(T value) {
        StackNode temp = new StackNode(value);
        if (this.top != null) {
            temp.next = this.top;
        }
        this.top = temp;

        this.length++;
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T result = this.top.data;
        this.top = this.top.next;
        this.length--;
        return result;
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return this.top.data;
    }


    private void printStack() {
        StackNode current = this.top;
        while (current.next != null) {
            System.out.println(current.data);
            current = current.next;
        }
        System.out.println(current.data);
    }

    public static void main(String[] args) {
        MyStack ll = new MyStack();

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
