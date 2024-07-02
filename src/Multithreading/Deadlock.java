package Multithreading;

public class Deadlock {
    public static void main(String[] args) {
        System.out.println("Started main thread");

        Object lock1 = "unni";
        Object lock2 = "rishi";

        Thread thread1 = new Thread(() -> {
            synchronized (lock1) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock2) {
                    System.out.println("lock acquired 1");
                }
            }
        }, "Thread1");

        Thread thread2 = new Thread(() -> {
            synchronized (lock2) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock1) {
                    System.out.println("lock acquired 2");
                }
            }
        }, "Thread2");

        thread1.start();
        thread2.start();

        System.out.println("exit main thread");

    }


}
