package Functional;

@FunctionalInterface
interface Calculator<T, R> {
    R operate(T t, T u);
}

public class CustomFunctionalInterface {
    public static void main(String[] args) {
        // Lambda for addition
        Calculator<Integer, Integer> add = (a, b) -> a + b;
        // Lambda for subtraction
        Calculator<Integer, Integer> subtract = (a, b) -> a - b;

        System.out.println("Addition: " + add.operate(10, 5));
        System.out.println("Subtraction: " + subtract.operate(10, 5));

    }
}


