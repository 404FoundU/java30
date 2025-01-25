package DSA.HashTable;


public class AnagramsString {


    public static void main(String[] args) {
        AnagramsString test = new AnagramsString();
        String str1 = "geekforkeeg";
        String str2 = "geekforgeek";
        System.out.println(test.testMethod(str1, str2));

    }

    private boolean testMethod(String str1, String str2) {
        HashTable<Character, Integer> hs = new HashTable<>();

        for (int i = 0; i < str1.length(); i++) {
            char ch = str1.charAt(i);
            if (hs.get(ch) == null) {
                hs.put(ch, 1);
            } else {
                Integer count = hs.get(ch);
                hs.put(ch, count + 1);
            }
        }
        for (int i = 0; i < str2.length(); i++) {
            char ch = str2.charAt(i);
            if (hs.get(ch) == null) {
                return false;
            } else {
                Integer count = hs.get(ch);
                if (count < 1) {
                    return false;
                }
                hs.put(ch, count - 1);
            }
        }

        for (HashTable.Node<Character, Integer> entry : hs.entrySet()) {
            if (entry.getValue() > 0) {
                return false;
            }
        }

        return true;
    }

}
