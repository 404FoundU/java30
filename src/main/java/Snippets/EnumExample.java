package Snippets;

import java.io.Serializable;

// extends enum class by default
enum Day {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY;
}

public class EnumExample {
    public static void main(String[] args) {
        // Get all enum values
        for (Day d : Day.values()) {
            System.out.println(d + " is at index " + d.ordinal());
        }

        // Convert string to enum
        Day day = Day.valueOf("FRIDAY");
        System.out.println("Converted: " + day);
    }
}

enum Size implements Serializable {
    SMALL(28), MEDIUM(32), LARGE(36), XLARGE(40);

    private final int sizeValue;

    // Constructor
    Size(int sizeValue) {
        this.sizeValue = sizeValue;
    }

    public int getSizeValue() {
        return sizeValue;
    }
}

class EnumWithFields {
    public static void main(String[] args) {
        Size mySize = Size.LARGE;
        System.out.println("Size: " + mySize + ", Value: " + mySize.getSizeValue());
    }
}

enum Operation {
    ADD {
        @Override
        public int apply(int a, int b) {
            return a + b;
        }
    },
    MULTIPLY {
        @Override
        public int apply(int a, int b) {
            return a * b;
        }
    };

    // Abstract method
    public abstract int apply(int a, int b);

    //custom method
    public void displayOperation() {
        System.out.println("Current operation: " + this);
    }
}

class EnumWithAbstractMethod {
    public static void main(String[] args) {
        System.out.println("10 + 5 = " + Operation.ADD.apply(10, 5));
        System.out.println("10 * 5 = " + Operation.MULTIPLY.apply(10, 5));
        Operation.ADD.displayOperation();
    }
}
