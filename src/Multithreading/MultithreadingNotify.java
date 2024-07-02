package Multithreading;

public class MultithreadingNotify {
    public static void main(String[] args) throws InterruptedException {
        Task task = new Task();
        task.start();
        synchronized (task) {
            System.out.println("trying to call wait method");
            task.wait(1000);
            System.out.println("Main thread got notification.");
        }
    }
}

class Task extends Thread {
    @Override
    public void run() {
        synchronized (this) {
            for (int i = 1; i <= 10; i++) {
                System.out.println("output" + i);
            }
            System.out.println("child Thread Sending notification");
            this.notifyAll();
        }
    }
}
