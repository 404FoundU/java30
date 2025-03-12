package Snippets;

import java.io.Serializable;

//extends Record class by default. Cannot extend another class
public record EmployeeRecord(String name, int id) implements Serializable { // comes with canonical constructor
    // can have compact constructor, no instance fields( need to be passed in canonical constructor )
    public static final String DEFAULT_NAME = "jay";

    public EmployeeRecord {
        if (id < 0) {
            throw new IllegalArgumentException();
        }
    }
    // Immutable - cannot have setters
    // toString(), hashCode(), equals() are included

    public String upperCase() {
        return name.toUpperCase();
    }
}

class employeeExample {
    public static void main(String[] args) {
        EmployeeRecord employeeRecord = new EmployeeRecord("Rishi", 1);
        System.out.println(employeeRecord.name());// ~getName()
        System.out.println(employeeRecord.upperCase());

    }
}
