package DesignPattern;

public class TVSetSingleton {
    private static volatile TVSetSingleton tvSetInstance = null;

    private TVSetSingleton() {
        System.out.println("TV Set instantiated");
    }

    public static TVSetSingleton getTVSetSingletonInstance() {
        if (tvSetInstance == null) { // optimisation
            synchronized (TVSetSingleton.class) { //t2
                if (tvSetInstance == null) {// double checking
                    tvSetInstance = new TVSetSingleton();
                }
            }
        }
        // heavy work done here
        return tvSetInstance;
    }
}

