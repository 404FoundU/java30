package DSA.Arrays.ArrayListConcept;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayListDemo {

    public static void main(String[] args) {
        //default class
        /*int i[] = new int[4];
        System.out.println(i[4]); / index out of bound*/
        //dynamic array
//        ArrayList list = new ArrayList(); // gives warning Raw use of parameterized class 'ArrayList'
        ArrayList<Object> list = new ArrayList<>(); // Write wrapper class in Generics
        System.out.println(list.size());
        list.add(100);
        list.add("Unni");
        list.add('u');
        System.out.println(list);
        System.out.println(list.get(2));
        System.out.println(list.size());
        //List with another collection
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(10, 20, 30));
        System.out.println(numbers);
        //combine 2 arrayList
        ArrayList<Object> list2 = new ArrayList<>();
        list2.add("bo");
        list2.addAll(list);
//        list.clear();
        //Clone an arrayList
        ArrayList<Object> cloneList = (ArrayList<Object>) list.clone();
        //create sublist(start, end - not included) - js slice
        ArrayList<Object> subList = new ArrayList<>(list.subList(1, 2));
        //search arrayList
        list.contains('u');
        list.indexOf('u');
        list.lastIndexOf('u');
        //remove arrayList
        /*
        list.remove(0);
        list.remove('u');
        */
        // Filter ArrayList - removeIf
//        int[] nArray = {1, 2, 3, 4};
        Integer nArray[] = new Integer[]{1, 2, 3, 4};
        ArrayList<Integer> num = new ArrayList<>(Arrays.asList(nArray));
        num.removeIf(n -> n % 2 == 0);
        System.out.println(num);
        //RetainAll - retain only the mentioned element - filter given  input
        ArrayList<String> names = new ArrayList<>(Arrays.asList("Unni1", "Unni2", "Unni1"));
        names.retainAll(Collections.singleton("Unni1"));
        System.out.println(names);
        //List to Array
        Object oArr[] = names.toArray();
        for (Object o : oArr) {
            System.out.println((String) o);
        }



        /*
        Remove Duplicate Elements
         */
        // 1. Linked Hashset
        ArrayList<Integer> intArr = new ArrayList<>(Arrays.asList(1, 2, 3, 1, 2, 4, 5, 6, 6, 7));
        LinkedHashSet<Integer> lSet = new LinkedHashSet<>(intArr);
        ArrayList<Integer> noDuplicateList = new ArrayList<>(lSet);
        // 2. Stream
        List<Integer> noDupList = intArr.stream().distinct().collect(Collectors.toList());

        /*
        Compare ArrayLists: sort and then apply equals
         */
        ArrayList<String> l1 = new ArrayList<>(Arrays.asList("A", "C", "F", "B"));
        ArrayList<String> l2 = new ArrayList<>(Arrays.asList("A", "C", "F", "B","E"));
        Collections.sort(l1);
        Collections.sort(l2);
        System.out.println(l1.equals(l2));

        // comapre and find additional element
        l2.removeAll(l1);

        // common elements
        l2.retainAll(l2);

        //Streams - immutable collection
        List<String> names1 = List.of("U", "N", "N");


//____________________________________________________________


    }
}
