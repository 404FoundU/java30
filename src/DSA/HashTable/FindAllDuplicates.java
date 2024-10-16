package DSA.HashTable;


import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicates {


    public static void main(String[] args) {
        FindAllDuplicates test = new FindAllDuplicates();
        int[] arr1 = {2, 5, 8, 9, 4, 2, 5};
        List<Integer> integers = test.testMethod(arr1);
        System.out.println(integers);
    }

    private List<Integer> testMethod(int[] arr1) {
        HashTable<Integer, Integer> hs = new HashTable<>();
        for (int j : arr1) {
            if (hs.get(j) == null) {
                hs.put(j, 1);
            } else {
                Integer count = hs.get(j);
                hs.put(j, count + 1);
            }
        }
        List<Integer> list = new ArrayList<>();

        for (HashTable.Node<Integer, Integer> entry : hs.entrySet()) {
            Integer k = entry.getKey();
            Integer v = entry.getValue();
            if (v > 1) {
                list.add(k);
            }
        }

        return list;
    }
}
