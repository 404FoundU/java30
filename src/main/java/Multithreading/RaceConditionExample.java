package Multithreading;

public class RaceConditionExample {
    private static int counter = 0;

    public static void main(String[] args) throws InterruptedException {
        Runnable incrementTask = () -> {
            for (int i = 0; i < 1000; i++) {
                counter++; // Critical section
            }
        };

        Thread thread1 = new Thread(incrementTask);
        Thread thread2 = new Thread(incrementTask);

        thread1.start();
        thread2.start();

        thread1.join(); // Wait for thread1 to finish
        thread2.join(); // Wait for thread2 to finish

        // Expected counter = 2000
        System.out.println("Final Counter Value: " + counter); // 1996 Thread2 overwrites Thread1's value
    }
}

