package Snippets;

import java.util.concurrent.atomic.AtomicLong;

public class AtomicLongExample {
    private AtomicLong counter = new AtomicLong(0);

    public void increment() {
        counter.incrementAndGet(); // Atomic increment
    }

    public long getCounter() {
        return counter.get(); // Thread-safe read
    }

    public static void main(String[] args) {
        AtomicLongExample example = new AtomicLongExample();

        // Simulate multiple threads incrementing the counter
        Runnable task = example::increment;

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final Counter Value: " + example.getCounter());
    }
}

