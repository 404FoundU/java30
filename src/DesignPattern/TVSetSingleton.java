package DesignPattern;

public class TVSetSingleton {
    private static volatile TVSetSingleton tvSetInstance;
    private String data;

    private TVSetSingleton(String data) {
        this.data = data;
        System.out.println("TV Set instantiated");
    }

    public static TVSetSingleton getTVSetSingletonInstance(String data) {
//        TVSetSingleton result = tvSetInstance;
        if (tvSetInstance == null) { // optimisation
            synchronized (TVSetSingleton.class) { //t2
                if (tvSetInstance == null) {// double check Locking
                    tvSetInstance = new TVSetSingleton(data);
                }
            }
        }
        // heavy work done here
        return tvSetInstance;
//        return result;
    }
}

