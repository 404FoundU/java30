import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;


public class HashMapDemo {

    public static void main(String[] args) {

        HashMap<String, Integer> map = new HashMap<>();
        map.put("unni", 10);
        map.put("unni2", 2);
        map.put("unni3", 3);
        printMap(map);
        if (map.containsKey("unni")) {
            Integer num = map.get("unni");
            System.out.println(num);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("key = " + entry.getKey());
            System.out.println("value = " + entry.getValue());
        }

        for (String name : map.keySet())
            System.out.println("key: " + name);

        // using values() for iteration over values
        for (Integer num : map.values())
            System.out.println("value: " + num);

        Iterator<Map.Entry<String, Integer>> itr = map.entrySet().iterator();

        while(itr.hasNext())
        {
            Map.Entry<String, Integer> entry = itr.next();
            System.out.println("Key = " + entry.getKey() +
                    ", Value = " + entry.getValue());
        }

        //Lambda
        map.forEach((k,v) -> System.out.println("Key = "
                + k + ", Value = " + v));

        map.clear();
        printMap(map);


    }

    public static void printMap(Map<String, Integer> map) {
        if (map.isEmpty()) {
            System.out.println("Map is empty");
        } else {
            System.out.println(map);
        }
    }
}
