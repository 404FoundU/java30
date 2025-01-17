package Functional.Examples;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class FunctionalExample {

    public static void main(String[] args) {
        List<String> wordList = Arrays.asList("apple", "banana", "cherry");

        //Creates an anonymous class that implements the Consumer<String> interface.
        //The Consumer<String> reference printElement holds the instance of this anonymous implementation.
        //compiler generates a class file yourClassName$1.class for this anonymous implementation.
        //This class is instantiated and assigned to Consumer<String> reference
        Consumer<String> printElement = new Consumer<>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };

        wordList.forEach(printElement);

        Consumer<String> stringConsumer = word -> System.out.println(word);
        wordList.forEach(stringConsumer);

        Consumer<String> printElement2 = new MyConsumer();// Uses consumer interface reference to hold instance
        wordList.forEach(printElement2);

        MyConsumer myConsumer = new MyConsumer();// Directly use myConsumer implementation
        wordList.forEach(myConsumer);


    }

}

class MyConsumer implements Consumer<String> {
    @Override
    public void accept(String s) {
        System.out.println(s);
    }
}

// Usage

