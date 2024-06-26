package Multithreading;

//https://www.youtube.com/watch?v=r_MbozD32eo
public class Multithreading {
    public static void main(String[] args) {
/*
        MultiThreadThing multiThreadThing = new MultiThreadThing();
        MultiThreadThing multiThreadThing2 = new MultiThreadThing();
//        multiThreadThing.run();// WOnt start a seperate thread
        multiThreadThing.start(); // kickoff new thread
        multiThreadThing2.start(); // kickoff second thread*/

       /* for (int i = 0; i < 5; i++) {
            MultiThreadThing multiThreadThing = new MultiThreadThing(i);
            multiThreadThing.start();
        }*/

        for (int i = 0; i < 5; i++) {
            MultiThreadThingWithRunnable multiThreadThingWithRunnable = new MultiThreadThingWithRunnable(i);
            Thread myThread = new Thread(multiThreadThingWithRunnable);
            myThread.start();
//            myThread.join();// Run the next thread only after this completes
            myThread.isAlive();
        }

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
            }
        });
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}
