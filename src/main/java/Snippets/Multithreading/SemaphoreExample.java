package Snippets.Multithreading;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {
    // Semaphore with 2 permits (allowing 2 threads to access a resource at once)
    private final Semaphore semaphore = new Semaphore(2);

    public void accessResource() {
        try {
            semaphore.acquire();  // Acquire a permit
            System.out.println("Thread " + Thread.currentThread().getName() + " accessing resource.");
            Thread.sleep(2000);  // Simulating resource access
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Thread " + Thread.currentThread().getName() + " releasing resource.");
            semaphore.release();  // Release the permit
        }
    }

    public static void main(String[] args) {
        SemaphoreExample example = new SemaphoreExample();

        // Creating multiple threads trying to access the resource
        for (int i = 0; i < 5; i++) {
            Runnable runnable = example::accessResource;
            new Thread(runnable).start();
        }
    }
}

