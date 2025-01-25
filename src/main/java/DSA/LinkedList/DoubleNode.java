package DSA.LinkedList;

class DoubleNode {
    int key, value; // maps to key in hashmap for adding and removing
    DoubleNode prev, next;

    DoubleNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
