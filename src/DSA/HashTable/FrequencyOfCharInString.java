package DSA.HashTable;


import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FrequencyOfCharInString {


    public static void main(String[] args) {
        FrequencyOfCharInString test = new FrequencyOfCharInString();
        test.testMethod("apple");
    }

    private void testMethod(String str) {
        Map<Character, Long> frequencyChar = str.chars()// // IntStream: [104, 101, 108, 108, 111] - hello - stream of primitive int
                .mapToObj(c -> (char) c) // IntStream into a Stream<Character>: ['h', 'e', 'l', 'l', 'o']
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));//groupingBy requires a Stream of objects or Stream<Integer>, not a primitive stream (IntStream).
        System.out.println(frequencyChar); // Output: {h=1, e=1, l=2, o=1}
        List<Character> uniqueChars = frequencyChar.entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .map(e -> e.getKey())
                .collect(Collectors.toList());
        System.out.println("duplicateChars = " + uniqueChars);

        String str2 = "Time after Time";
        String[] s = str2.split(" ");
        Map<String, Long> freqString = Arrays.stream(s)
                .collect(Collectors.groupingBy(a -> a, Collectors.counting()));
        System.out.println("freqString = " + freqString);
    }
}
