package DSA.HashSet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InvertedPairs {
    public static void checkInvertedPairs(int[] arr) {
        Set<String> pairSet = new HashSet<>();
        List<String> missingPairs = new ArrayList<>();

        // Form pairs and store them as "a,b" in a set
        for (int i = 0; i < arr.length; i += 2) {
            String pair = arr[i] + "," + arr[i + 1];
            String invertedPair = arr[i + 1] + "," + arr[i];

            if (pairSet.contains(invertedPair)) {
                pairSet.remove(invertedPair); // Remove if match found
            } else {
                pairSet.add(pair);
            }
        }

        // If the set is empty, all pairs have their inverted counterpart
        if (pairSet.isEmpty()) {
            System.out.println("YES");
        } else {
            System.out.println("Missing inverted pairs:");
            for (String p : pairSet) {
                System.out.println(p);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {6, 4, 5, 3, 4, 6, 3, 5}; // Example input
        checkInvertedPairs(arr);
    }
}

