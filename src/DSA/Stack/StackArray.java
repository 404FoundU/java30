package DSA.Stack;


import java.util.EmptyStackException;

public class StackArray {



    private int[] stack;
    private int top;

    public StackArray(int capacity) {
        this.stack = new int[capacity];
        this.top = -1;
    }

    public boolean isEmpty() {
        return this.top <0;
    }

    private void push(int value) {
        if (this.top+1 == this.stack.length) {
            throw new RuntimeException("stack is full");

        }
        this.top++;
        this.stack[this.top] = value;
    }



    private int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        int result = this.stack[this.top];

        this.top--;

        return result;
    }

    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return this.stack[this.top];
    }


    private void printStack() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        for (int i = this.top; i > 0; i--) {
            System.out.println(this.stack[i]);

        }
    }

    public static void main(String[] args) {
        StackArray ll = new StackArray(6);

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
