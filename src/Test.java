import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
    public static void main(String[] args) {
        testMethod();

    }

    private static void testMethod() {
        int PAGE_SIZE = 1000;
        double totalEntityCount = 0.1;
        int totalPage = (int) Math.ceil(totalEntityCount / PAGE_SIZE);
        int test = 0;

    }

}
