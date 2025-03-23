package Snippets.Multithreading;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

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

    public E get() throws InterruptedException {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                // block thread
                isNotEmpty.await();
            }
            E e = queue.remove();
            isNotFull.notifyAll();
            return e;
        } finally {
            lock.unlock();
        }
    }
}
