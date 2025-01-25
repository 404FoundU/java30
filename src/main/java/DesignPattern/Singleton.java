package DesignPattern;

// Bill Pugh Singleton
public class Singleton {
    private Singleton() {
    }

    // Inner static helper class
    private static class SingletonHelper {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonHelper.INSTANCE;
    }
}


enum SingletonEnum {
    INSTANCE;

    public void show() {
        System.out.println("Singleton using Enum");
    }
}
