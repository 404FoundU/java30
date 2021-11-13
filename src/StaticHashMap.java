import java.util.AbstractMap;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StaticHashMap {
    // Create static hasmap
    public static HashMap<String, Integer> marks;

    static {
        marks = new HashMap<>();
        marks.put("A", 100);
        marks.put("B", 200);
    }

    public static void main(String[] args) {
        System.out.println(StaticHashMap.marks.get("A"));
        //Immutable Map - Only one value
        Map<String, Integer> map1 = Collections.singletonMap("test", 100);
//        map1.put("abc", 200); // Unsupported operation
// Map vs Hashmap - https://stackoverflow.com/a/28538905/9397387
        //Stream - 2D array of strings and collecting from Map
        Map<String, String> map2 = Stream.of(new String[][]{
                {"Unni", "A"},
                {"Unni2", "A+"},
        }).collect(Collectors.toMap(data -> data[0], data -> data[1]));
        System.out.println(map2.get("Unni"));
        //Using SimpleEntry - Mutable
        Map<String, String> map3 = Stream.of(
                new AbstractMap.SimpleEntry<>("U", "Java"),
                new AbstractMap.SimpleEntry<>("B", "C")
        ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println(map3.get("U"));
//Using SimpleEntry - IMMutable
        Map<String, String> map4 = Stream.of(
                new AbstractMap.SimpleImmutableEntry<>("U", "Java"),
                new AbstractMap.SimpleImmutableEntry<>("B", "C")
        ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
//        System.out.println(map3.get("U"));
        //empty Map - cannot add key value
        Map<String, String> emptyMap = Map.of();
//        emptyMap.put("U", "J"); // Unsupported OPeration
        //Singleton Map
        Map<String, String> singletonMap = Map.of("K", "V");
//        singletonMap.put("K2", "V3");// unsupported operation
        // MultiValue Map - Max 10 values - Mutable
        Map<String, String> multiMap = Map.of("K1", "V1", "K2", "V2");

        // ofEntry - Immutable
        Map<String, String> entryMap = Map.ofEntries(
                new AbstractMap.SimpleEntry<>("U", "Java")
        );





    }
}
