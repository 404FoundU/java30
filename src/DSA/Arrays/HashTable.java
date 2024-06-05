package DSA.Arrays;


import java.text.MessageFormat;
import java.util.Arrays;
import java.util.EmptyStackException;

//https://www.youtube.com/watch?v=ZKPWMOSIh7Q&list=PL6Zs6LgrJj3tDXv8a_elC6eT_4R5gfX4d&index=182
//https://github.com/geekific-official/geekific-youtube/blob/main/data-structures/queue/src/main/java/com/youtube/geekific/array/Queue.java
public class HashTable<K,V> {

    private static final int DEFAULT_CAPACITY=10;
    private HashNode[] buckets;
    private int size;



    public HashTable() {

        buckets = new HashNode[DEFAULT_CAPACITY];
    }

    private static class HashNode<K,V>{
        private K key;
        private V value;

        private HashNode<K,V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

    }


    private void put(K key, V value) {
        HashNode<K, V> newNode = new HashNode<>(key, value);
        int bucketIndex = getBucketIndex(key);
        HashNode<K,V> currentNode = (HashNode) this.buckets[bucketIndex];
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

    private V get(K key) {
        int bucketIndex = getBucketIndex(key);
        HashNode<K,V> currentNode = (HashNode) this.buckets[bucketIndex];

            while (currentNode != null) {
                if (currentNode.key == key) {
                    return currentNode.value;
                }
                currentNode = currentNode.next;
            }
        return (V) "0";
    }
    private int getBucketIndex(K key) {
        int hashCode = key.hashCode();
        int index = hashCode % buckets.length;
        return index < 0 ? index * -1 : index;
    }

    private boolean isEmpty() {
        return        this.size == 0;
    }


    private void printHashTable() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        for (int i = 0; i < this.buckets.length; i++) {
            HashNode<K, V> currentNode = (HashNode) this.buckets[i];
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
        HashTable<String, String> ll = new HashTable<>();

        ll.put("unni", "1");
        ll.put("boya", "2");
        ll.put("rishi", "3");
        ll.put("rishi", "5");
        ll.put("sreeku", "4");
        ll.printHashTable();
        System.out.println(MessageFormat.format("Id is: {0}", ll.get("sreeku")));







    }
}
