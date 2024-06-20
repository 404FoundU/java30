package DSA.HashTable;


import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

//https://www.youtube.com/watch?v=ZKPWMOSIh7Q&list=PL6Zs6LgrJj3tDXv8a_elC6eT_4R5gfX4d&index=182
//https://github.com/geekific-official/geekific-youtube/blob/main/data-structures/queue/src/main/java/com/youtube/geekific/array/Queue.java
public class HashTable<K,V> {

    private static final int DEFAULT_CAPACITY=10;
    private Node[] buckets;
    private int size;
    public HashTable() {
        buckets = new Node[DEFAULT_CAPACITY];
    }

    private static class Node<K,V>{
        private K key;
        private V value;
        private Node<K,V> next;
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }


     void put(K key, V value) {
        Node<K, V> newNode = new Node<>(key, value);
        int bucketIndex = getBucketIndex(key);
        Node<K,V> currentNode = (Node) this.buckets[bucketIndex];
        if (currentNode == null) {
            this.buckets[bucketIndex] = newNode;
        } else {
            while (currentNode != null) {
                if (currentNode.key == key) {
                    currentNode.value = value;
                    return;
                }
                currentNode = currentNode.next;

            }
            currentNode.next = newNode;
            return;
        }

        this.size++;

    }

     V get(K key) {
        int bucketIndex = getBucketIndex(key);
        Node<K,V> currentNode = (Node) this.buckets[bucketIndex];

            while (currentNode != null) {
                if (currentNode.key == key) {
                    return currentNode.value;
                }
                currentNode = currentNode.next;
            }
        return null;
    }

    private List<K> keys() {
        ArrayList<K> keys = new ArrayList<>();
        for (int i = 0; i < buckets.length - 1; i++) {
            Node<K, V> current = (Node) this.buckets[i];
                while (current != null) {
                    keys.add(current.key);
                    current = current.next;
            }
        }
        return keys;

    }
    private int getBucketIndex(K key) {
        int hashCode = key.hashCode();
        int index = hashCode % buckets.length;
        return index < 0 ? index * -1 : index;
    }

    public int hash(String key) {
        int hash = 0;
        char[] keyChars = key.toCharArray();
        for (int i = 0; i < keyChars.length; i++) {
            int asciiValue = keyChars[i];
            hash = (hash + asciiValue * 23) % buckets.length;
        }
        return hash;
    }


    private boolean isEmpty() {
        return        this.size == 0;
    }


    private void printHashTable() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        for (int i = 0; i < this.buckets.length; i++) {
            Node<K, V> currentNode = (Node) this.buckets[i];
            if (currentNode == null) {
                continue;
            }

            while (currentNode != null) {
                System.out.println("key: "+ currentNode.key + "value: " + currentNode.value);
                currentNode = currentNode.next;
            }
        }
    }



    public static void main(String[] args) {
        HashTable<String, String> map = new HashTable<>();

        map.put("unni", "1");
        map.put("boya", "2");
        map.put("rishi", "3");
        map.put("rishi", "5");
        map.put("sreeku", "4");
        map.printHashTable();
        System.out.println(MessageFormat.format("Id is: {0}", map.get("sreeku")));

        map.keys()
                .forEach(System.out::println);






    }
}
