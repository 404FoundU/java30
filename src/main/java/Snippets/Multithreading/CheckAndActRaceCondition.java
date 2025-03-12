package Snippets.Multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CheckAndActRaceCondition {
    int balance = 100; // Shared resource
    private final Lock lock = new ReentrantLock(); // Thread-safe lock

    // A method that contains the logic to withdraw money
    public void withdraw() {
        lock.lock();
        try {
            System.out.println("Waiting to withdraw money: " + Thread.currentThread().getName());
            if (balance >= 50) {
                System.out.println("Withdrawing money: " + Thread.currentThread().getName());
                balance -= 50;
            } else {
                System.out.println("Withdrawal not done for: " + Thread.currentThread().getName());
            }
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        CheckAndActRaceCondition bank = new CheckAndActRaceCondition(); // Create a single shared instance

        // The lambda provides the implementation of the run() method directly,
        // without requiring the class to implement Runnable.
        Thread ramesh = new Thread(() -> bank.withdraw(), "ramesh");
        Thread payal = new Thread(() -> bank.withdraw(), "payal");

        ramesh.start();
        payal.start();
    }
}



