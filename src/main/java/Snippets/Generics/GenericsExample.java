package Snippets.Generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsExample {
    public static void main(String[] args) {
        // Create a list of integers
        List<Integer> intList = new ArrayList<>();
        intList.add(3); // Add an integer to the list

        // Pass the list to the printList method
        printList(intList);

        // Create a list of strings
        List<String> stringList = new ArrayList<>();
        stringList.add("Hello");
        stringList.add("World");

        // Pass the string list to the same method
        printList(stringList);
    }

    // Method to print any list
    private static void printList(List<?> myList) {
        System.out.println("List contents: " + myList);
    }
}

