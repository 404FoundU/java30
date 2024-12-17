package DSA.Tree.Trie;


import java.util.HashMap;

class TrieNode {
    HashMap<Character, TrieNode> children; // HashMap to hold children nodes dynamically
    boolean isEndOfWord; // Flag to mark the end of a word

    public TrieNode() {
        children = new HashMap<>();
        isEndOfWord = false;
    }
}


