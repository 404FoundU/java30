package ArrayListConcept;

import java.util.ArrayList;
import java.util.Iterator;

public class ListDemo {
    public static void main(String[] args) {
        ArrayList<String> list1 =new ArrayList<String>();
        list1.add("Unni1");
        list1.add("Unni2");
        list1.add("Unni3");

        System.out.println(list1);

        String name = list1.get(2);
        System.out.println(name);

        list1.set(0, "u");
        System.out.println(list1.get(2));
        if (list1.contains("u")) {
            list1.remove(2);
        }
        System.out.println(list1);

        //Foreach
        for (String str : list1) {
            System.out.println(str);
        }
        for (int i =0; i< list1.size(); i++) {
            System.out.println(list1.get(i));
        }
        //streams with Lamda
        System.out.println("____________lamda______");
        list1.stream().forEach(el-> System.out.println(el));
        //Iterator
        Iterator<String> itr = list1.iterator();//apply iterator
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}
