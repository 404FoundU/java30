package HashMapDemo;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class SetDemo {
    public static void main(String[] args) {
//        HashSet<String> set = new HashSet<String>();
        TreeSet<String> set = new TreeSet<String>();
        set.add("Unni6");
        set.add("Unni2");
        set.add("Unni3");
        set.add("Unni3");
        System.out.println(set);

        Iterator<String> itr = set.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}
