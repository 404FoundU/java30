package Snippets.Multithreading;

public class MultiThreadThingWithRunnable implements Runnable {
    private final int threadNumber;

    public MultiThreadThingWithRunnable(int threadNumber) {
        this.threadNumber = threadNumber;
    }

    @Override
    public void run() {

    for (int i = 0; i < 5; i++) {
        System.out.println(i + " from threadNumber " + threadNumber);
       /* if (threadNumber == 3) {
            throw new RuntimeException();
        }*/
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }

    }
    }
}
