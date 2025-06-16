import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        testMethod();

        List<String> listA = Stream.of("a", "b", "c")
                .collect(Collectors.toList());
        System.out.println(listA.getClass());

        List<String> listB = Stream.of("a", "b", "c")
                .toList();
        System.out.println(listB.getClass());
    }

    private static void testMethod() {

        //use iterator to remove not forEach
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("banana");
        list.add("cherry");

        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().equals("banana")) {
                it.remove();  // safely removes "banana"
            }
        }
        System.out.println(list); // [apple, cherry]

    }

}





