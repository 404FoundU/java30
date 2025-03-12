package Snippets.Functional;


public class RunnableLambda {
    public static void main(String[] args) {
        RunnableLambda test = new RunnableLambda();
        test.testMethod();
    }

    private void testMethod() {

        /*
        Java 8
         */

        Runnable runnableTest = new Runnable(){
            @Override
            public void run() {
                System.out.println("Runnable");
            }
        };
        new Thread(runnableTest).start();
        /*
        java 8
         */
       Runnable run= () -> System.out.println("Runnable2");
        new Thread(run).start();

    }


}
