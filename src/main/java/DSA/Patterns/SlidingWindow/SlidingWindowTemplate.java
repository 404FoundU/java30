package DSA.Patterns.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class SlidingWindowTemplate {
    public int slidingWindowTemplate(String s) {
        // Step 1: Define necessary variables
        int left = 0, maxLength = 0;
        Map<Character, Integer> map = new HashMap<>(); // Can use HashSet if needed

        // Step 2: Expand the window by moving the right pointer
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            // If the character is a duplicate, shrink the window from the left
            while (map.containsKey(currentChar) && map.get(currentChar) > 0) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1); // Decrement count
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar); // Remove if count reaches zero
                }
                left++; // Move left pointer
            }

            // Add current character to the map
            map.put(currentChar, map.getOrDefault(currentChar, 0) + 1);

            // Update result
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength; // Returns the max valid window length
    }
}
