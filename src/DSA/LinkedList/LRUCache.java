package DSA.LinkedList;

import java.util.HashMap;
import java.util.Map;

//https://www.youtube.com/watch?v=NDpwj0VWz1U
class LRUCache {
    private class Node {
        int key, value;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final Map<Integer, Node> map;
    private final Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new Node(0, 0); // Dummy head
        this.tail = new Node(0, 0); // Dummy tail
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        // Move the accessed node to the front
        Node node = map.get(key);
        remove(node);
        insertToFront(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            // Remove the old node
            remove(map.get(key));
        } else if (map.size() == capacity) {
            // Evict the least recently used item
            remove(tail.prev);
        }
        // Insert the new node
        Node node = new Node(key, value);
        insertToFront(node);
        map.put(key, node);
    }

    private void remove(Node node) {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertToFront(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2); // Capacity = 2

        cache.put(1, 1); // Cache is {1=1}
        cache.put(2, 2); // Cache is {1=1, 2=2}
        System.out.println(cache.get(1)); // Returns 1 (cache is {2=2, 1=1})
        cache.put(3, 3); // Evicts key 2, Cache is {1=1, 3=3}
        System.out.println(cache.get(2)); // Returns -1 (not found)
        cache.put(4, 4); // Evicts key 1, Cache is {3=3, 4=4}
        System.out.println(cache.get(1)); // Returns -1 (not found)
        System.out.println(cache.get(3)); // Returns 3 (cache is {4=4, 3=3})
        System.out.println(cache.get(4)); // Returns 4 (cache is {3=3, 4=4})
    }

}

