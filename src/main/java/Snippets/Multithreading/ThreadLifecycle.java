package Snippets.Multithreading;
/*
New (Thread Created)
    |
    |  start()
    v
Runnable (Waiting for CPU)
    |
    |  CPU scheduler picks thread
    v
Running (Executing code)
    |
    |  Thread.sleep(2000)
    v
Timed Waiting (Paused for a fixed time)
    |
    |  Time expires
    v
Runnable (Ready to run again)
    |
    |  CPU schedules thread
    v
Running (Continues execution)
    |
    |  Another thread calls join()
    v
Timed Waiting (Current thread waits for another thread to finish)
    |
    |  Target thread completes
    v
Runnable (Ready to resume execution)
    |
    |  CPU schedules thread
    v
Running (Resumes execution)
    |
    |  Execution completes
    v
Terminated (Thread finished)

*/


class MyThread extends Thread {
    public void run() {
        try {
            System.out.println("CPU scheduler picked thread.");
            System.out.println("Thread is running");
            Thread.sleep(5000); // Moves to Timed Waiting
            System.out.println("Thread state after sleep: " + Thread.currentThread().getState());
            System.out.println("Thread is running");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread completed execution.");
    }
}

public class ThreadLifecycle {
    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread();
        System.out.println("Thread state after creation: " + t1.getState()); // NEW
        t1.start();
        System.out.println("Thread state after start: " + t1.getState());

        Thread.sleep(500); // Pause main thread. Allow t1 to start
        System.out.println("Thread state while sleeping: " + t1.getState()); // TIMED_WAITING

        System.out.println("Main thread waiting for t1 to finish...");
        t1.join(); // Main thread enters TIMED_WAITING or WAITING

        System.out.println("Thread state after join(): " + t1.getState()); // TERMINATED
        System.out.println("Main thread resumes execution.");

    }
}





