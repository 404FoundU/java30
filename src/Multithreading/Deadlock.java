package Multithreading;


/*
Blocked for Lock Acquisition state
 */
public class Deadlock {
    public static void main(String[] args) {
        System.out.println("Started main thread");

        Object lock1 = "unni";
        Object lock2 = "rishi";

        Thread thread1 = new Thread(() -> {
            synchronized (lock1) {
                try {
                    Thread.sleep(10); // wont relinquish the lock

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
                    System.out.println("lock acquired for " + Thread.currentThread().getName());
                }
            }
        }, "Thread2");

        thread1.start();
        System.out.println(thread1.getState().name());
        thread2.start();
        System.out.println(thread1.getState().name());
        System.out.println("exit main thread");

    }


}
