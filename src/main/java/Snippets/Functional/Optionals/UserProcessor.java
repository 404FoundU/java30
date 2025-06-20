package Snippets.Functional.Optionals;

import java.util.Objects;

class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class UserProcessor {
    public static void main(String[] args) {
        UserProcessor processor = new UserProcessor();

        // Case 1: Valid user
        User validUser = new User("Unni");
        processor.processUser(validUser);

        // Case 2: Null user (simulate DB/API returning null)
        User nullUser = null;
        processor.processUser(nullUser); // This will throw a clear exception
    }

    public void processUser(User user) {
        // Enforce non-null user
        Objects.requireNonNull(user, "User cannot be null");

        // Safe to use user now
        System.out.println("Processing user: " + user.getName());
    }
}

