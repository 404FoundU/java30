package Snippets.Generics;

import java.io.Serializable;

public class Printer<T extends Integer & Serializable> {
    T thingToPrint;

    public Printer(T thingToPrint) {
        this.thingToPrint = thingToPrint;
    }

    public static void main(String[] args) {
        Printer<Integer> printer = new Printer<>(23);
    }

    private static <T> void shout(T thingToShout) {
        System.out.println(thingToShout + "!!!!!");
    }
}

