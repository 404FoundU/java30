package Snippets.Multithreading;


import java.util.LinkedList;
import java.util.Queue;

//https://www.youtube.com/watch?v=WldMTtUWqTg&t=4485s
public class BlockingQueue {
    private Queue<Integer> q;
    private final int capacity;

    public BlockingQueue(int capacity) {
        this.q = new LinkedList<>();
        this.capacity = capacity;
    }

    public boolean add(int item) {

        synchronized (q) {
            while (q.size() == capacity) {
                try {
                    q.wait(); //adder1, adder2
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            q.add(item);
            q.notifyAll();
            return true;
        }

    }

    public int remove() {

        synchronized (q) {
            while (q.size() == 0) {

                try {

                    q.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            int element = q.poll();
            q.notifyAll();
            return element;

        }

    }

    public static void main(String[] args) {
        BlockingQueue ll = new BlockingQueue(6);

        ll.add(1);
        ll.remove();


    }
}
