package Multithreading;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureExample {
    public static void main(String[] args) {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> { // VOid return
            System.out.println("Executing task in: " + Thread.currentThread().getName());
        });

        future.join(); // Wait for completion
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {// returns String
            System.out.println("Executing task in: " + Thread.currentThread().getName());
            return "Hello, World!";
        });

        String result = future2.join(); // Wait for completion and get the result
        System.out.println("Result: " + result);


    }
}
