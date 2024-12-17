package DSA.Tree.Trie;

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode(); // Initialize root node
    }

    // Inserts a word into the trie
    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            // Check if the character already exists in the current node's children
            if (!node.children.containsKey(ch)) {
                // If not, add a new TrieNode for this character
                node.children.put(ch, new TrieNode());
            }

            // Move to the child node corresponding to the current character
            node = node.children.get(ch);
        }

        node.isEndOfWord = true; // Mark the end of the word
    }

    // Returns true if the word is in the trie
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEndOfWord;
    }

    // Returns true if any word in the trie starts with the given prefix
    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    // Helper method to search for a prefix or word
    private TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            if (!node.children.containsKey(ch)) {
                return null; // Prefix or word not found
            }
            node = node.children.get(ch);
        }
        return node; // Return the node at the end of the prefix
    }

    public static void main(String[] args) {
        Trie trie = new Trie();

        // Insert words
        trie.insert("apple");
        System.out.println("Inserted 'apple'");

        // Search words
        System.out.println("Search 'apple': " + trie.search("apple"));   // true
        System.out.println("Search 'app': " + trie.search("app"));       // false

        // StartsWith prefix
        System.out.println("StartsWith 'app': " + trie.startsWith("app")); // true

        // Insert more words
        trie.insert("app");
        System.out.println("Inserted 'app'");

        // Search again
        System.out.println("Search 'app': " + trie.search("app"));       // true
    }
}
