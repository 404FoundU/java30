package DSA.Patterns.Heaps;

import java.util.Arrays;

public class BinaryHeap {

    int[] h;
    int maxSize;
    int size;

    BinaryHeap(int maxSize) {
        this.maxSize = maxSize;
        size = 0;
        h = new int[maxSize];
    }

    void insert(int val) {
        if (size >= maxSize) {
            System.out.println("heap full");
            return;
        }
        h[size] = val;
        heapifyBottomToTop(size); // ✅ use current size before incrementing
        size++;
    }

    private void heapifyBottomToTop(int index) {
        if (index <= 0) {
            return;
        }
        int parentIndex = (index - 1) / 2;

        if (h[parentIndex] < h[index]) {
            swap(parentIndex, index);
            heapifyBottomToTop(parentIndex);
        }
    }

    private void heapifyTopToBottom(int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;

        if (left < size && h[left] > h[largest]) {
            largest = left;
        }

        if (right < size && h[right] > h[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(i, largest);
            heapifyTopToBottom(largest);
        }
    }

    int extractHead() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }

        int head = h[0];
        h[0] = h[size - 1];
        size--;
        heapifyTopToBottom(0);
        return head;
    }

    void levelOrderTraversalArrayHeap() {
        System.out.print("Level Order: ");
        for (int i = 0; i < size; i++) {
            System.out.print(h[i] + " ");
        }
        System.out.println();
    }

    void swap(int index1, int index2) {
        int temp = h[index1];
        h[index1] = h[index2];
        h[index2] = temp;
    }

    boolean isEmpty() {
        return size == 0;
    }

    public void printHeap() {
        for (int i = 0; i < size / 2; i++) {
            System.out.print("Parent: " + h[i]);
            if (leftChild(i) < size) {
                System.out.print(" Left Child: " + h[leftChild(i)]);
            }
            if (rightChild(i) < size) {
                System.out.print(" Right Child: " + h[rightChild(i)]);
            }
            System.out.println();
        }
    }

    private int leftChild(int index) {
        return (2 * index) + 1;
    }

    private int rightChild(int index) {
        return (2 * index) + 2;
    }

    public static void main(String[] args) {
        BinaryHeap heap = new BinaryHeap(7);
        heap.insert(20);
        heap.insert(10);
        heap.insert(15);
        heap.insert(5);
        heap.insert(1);
        heap.insert(3);
        heap.insert(4);

        System.out.println("Heap before extraction: " + Arrays.toString(Arrays.copyOf(heap.h, heap.size)));

        int max = heap.extractHead();
        System.out.println("Extracted head: " + max);

        System.out.println("Heap after extraction: " + Arrays.toString(Arrays.copyOf(heap.h, heap.size)));

        heap.levelOrderTraversalArrayHeap();
    }
}



