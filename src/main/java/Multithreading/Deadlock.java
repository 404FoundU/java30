package Multithreading;


/*
Blocked for Lock Acquisition state
 */
public class Deadlock {
    public static void main(String[] args) {
        System.out.println("Started main thread");

        // Two locks
        Object lock1 = "Lock1";
        Object lock2 = "Lock2";

        // Thread 1 tries to acquire lock1 first, then lock2
        Thread thread1 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println(Thread.currentThread().getName() + " acquired lock1");
                try {
                    // Simulate work with lock1
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " waiting to acquire lock2");
                synchronized (lock2) {
                    System.out.println(Thread.currentThread().getName() + " acquired lock2");
                }
            }
        }, "Thread1");

        // Thread 2 tries to acquire lock2 first, then lock1
        Thread thread2 = new Thread(() -> {
            synchronized (lock2) {
                System.out.println(Thread.currentThread().getName() + " acquired lock2");
                try {
                    // Simulate work with lock2
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " waiting to acquire lock1");
                synchronized (lock1) {
                    System.out.println(Thread.currentThread().getName() + " acquired lock1");
                }
            }
        }, "Thread2");

        // Start both threads
        thread1.start();
        thread2.start();

        // Monitor threads' states
        new Thread(() -> {
            while (true) {
                System.out.println("Thread1 State: " + thread1.getState());
                System.out.println("Thread2 State: " + thread2.getState());
                try {
                    Thread.sleep(1000); // Check states periodically
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}

