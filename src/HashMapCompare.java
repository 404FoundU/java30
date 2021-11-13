import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class HashMapCompare {
    public static void main(String[] args) {
        HashMap<Integer, String> map1 = new HashMap<>();
        map1.put(1, "A");
        map1.put(2, "B");
        map1.put(3, "C");

        HashMap<Integer, String> map2 = new HashMap<>();
        map2.put(3, "C");
        map2.put(1, "A");
        map2.put(2, "B");
//Duplicate key
        HashMap<Integer, String> map3 = new HashMap<>();
        map3.put(3, "C");
        map3.put(1, "A");
        map3.put(2, "B");
        map3.put(3, "D");

        HashMap<Integer, String> map4 = new HashMap<>();
        map4.put(1, "A");
        map4.put(2, "B");
        map4.put(3, "C");
        map4.put(4, "D");

//Duplicate value
        HashMap<Integer, String> map5 = new HashMap<>();
        map5.put(3, "C");
        map5.put(1, "A");
        map5.put(2, "B");
        map5.put(4, "C");
        // key value compare
        System.out.println(map1.equals(map2));
        System.out.println(map1.equals(map3));

        // compare hashmap for same keys: keySet()
        System.out.println(map1.keySet().equals(map2.keySet()));
        //set ignore duplicate value
        System.out.println(map1.keySet().equals(map3.keySet()));



        // find extra key
        //combine keys using HashSet
        HashSet<Integer> combineKeys = new HashSet<>(map1.keySet());
        combineKeys.addAll(map4.keySet());
        combineKeys.removeAll(map1.keySet());
        System.out.println(combineKeys);

        //compare by values - no duplicates
        ArrayList<String> value1 = new ArrayList<>(map1.values());
        ArrayList<String> value2 = new ArrayList<>(map2.values());
        System.out.println(value1.equals(value2));
        // no duplicates
        HashSet<String> value3 = new HashSet<>(map1.values());
        HashSet<String> value4 = new HashSet<>(map5.values());
        System.out.println(value3.equals(value4));





    }
}
