package Snippets.Multithreading;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


//https://www.youtube.com/watch?v=UOr9kMCCa5g
public class MyBlockingQueue<E> {

    private final Queue<E> queue;
    private int maxSize = 16;

    private Lock lock = new ReentrantLock(true);
    private Condition isNotFull = lock.newCondition();
    private Condition isNotEmpty = lock.newCondition();

    MyBlockingQueue(int maxSize) {
        queue = new LinkedList<>();
        this.maxSize = maxSize;

    }

    public void put(E e) throws InterruptedException {
        lock.lock();
        try {
            while (queue.size() == maxSize) {
                //block thread
                isNotFull.await();
            }
            queue.add(e);
            isNotEmpty.signalAll();

        } finally {
            lock.unlock();
        }
    }

    public E take() throws InterruptedException {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                // block thread
                isNotEmpty.await();
            }
            E e = queue.remove();
            isNotFull.signalAll();
            return e;
        } finally {
            lock.unlock();
        }
    }
}

class ProducerConsumer {

    public static void main(String[] args) {
        MyBlockingQueue<String> q = new MyBlockingQueue<>(10);

        Runnable producer = () -> {
            int count = 0;
            try {
                while (true) {
                    String item = "item" + count++;
                    System.out.println("produce" + item);
                    q.put(item);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        Runnable consumer = () -> {
            try {
                while (true) {
                    String item = q.take();
                    System.out.println("consumed" + item);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        new Thread(producer).start();
        new Thread(consumer).start();

    }
}
