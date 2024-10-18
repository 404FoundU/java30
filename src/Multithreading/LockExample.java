package Multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample {
    private final Lock lock = new ReentrantLock();
    private int counter = 0;

    public void increment() {
        lock.lock();  // Acquire the lock
        try {
            counter++;
            System.out.println("Counter: " + counter + " - Thread: " + Thread.currentThread().getName());
        } finally {
            lock.unlock();  // Always release the lock in a finally block
        }
    }

    public static void main(String[] args) {
        LockExample example = new LockExample();
        Runnable runnable = () -> example.increment();

        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);

        t1.start();
        t2.start();
    }
}
