package DSA.Stack;


import java.util.Arrays;
import java.util.EmptyStackException;


//https://github.com/geekific-official/geekific-youtube/blob/main/data-structures/queue/src/main/java/com/youtube/geekific/array/Queue.java
public class QueueArray<T> {
    private Object[] queue;
    private static final int DEFAULT_CAPACITY=10;
    private int size;
    private int beginning;
    public QueueArray() {
        this.queue =  new Object[DEFAULT_CAPACITY];
        this.size = 0;
        this.beginning = 0;
    }
    private boolean isEmpty() {
        return        this.size == 0;
    }
    private void enqueue(T value) {
        ensureCapacity();
        this.queue[size++] = value;
    }

    private T dequeue() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T value = (T) this.queue[0];

        int lengthToMove = this.size - 1;
        System.arraycopy(queue, 1, queue, 0, lengthToMove);// this.beginning ++
        this.queue[--size] = null;
        return value;
    }




    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return (T) this.queue[0];
    }


    private void printQueue() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        for (int i = 0; i < this.size; i++) {
            System.out.println(this.queue[i]);

        }
    }

    private void ensureCapacity() {
        if (this.size == this.queue.length) {
            int newCapacity = this.size + (this.size >> 1);
            this.queue = Arrays.copyOf(this.queue, newCapacity);
        }
    }

    public static void main(String[] args) {
        QueueArray<Integer> ll = new QueueArray<>();

        ll.enqueue(1);
        ll.enqueue(2);
        ll.enqueue(3);
        ll.enqueue(5);
        ll.enqueue(6);
        ll.enqueue(7);
        ll.printQueue();


        System.out.println("dequeue: "+ ll.dequeue());

        ll.printQueue();

    }
}
