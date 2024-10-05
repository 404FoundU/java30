package DSA.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle {
    public static void main(String[] args) {
        PascalsTriangle test = new PascalsTriangle();
        test.testMethod(5);
    }

    private void testMethod(int n) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> firstRow = new ArrayList<>(List.of(1));
        triangle.add(firstRow);

        for (int i = 1; i < n; i++) {
            List<Integer> prevRow = triangle.get(i - 1);
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for (int j = 1; j < i; j++) {
                row.add(prevRow.get(j - 1) + prevRow.get(j));
            }
            row.add(1);
            triangle.add(row);
        }
        System.out.println("triangle = " + triangle);
    }


}
