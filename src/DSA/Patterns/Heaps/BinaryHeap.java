package DSA.Patterns.Heaps;

import java.util.Arrays;

import static DSA.Utility.swapArrayIndexes;

public class BinaryHeap {
    int[] array;
    int sizeOfTree;

    BinaryHeap(int size) {
        array = new int[size + 1];
        this.sizeOfTree = 0;
    }

    void insert(int val, String heapType) {
        array[++sizeOfTree] = val; // Insert as the last element
        heapifyBottomToTop(sizeOfTree, heapType);
    }

    private void heapifyBottomToTop(int index, String heapType) {
        int parentIndex = index / 2; // Corrected parent index
        if (index <= 1) {
            return;
        }
        if (heapType.equals("MIN")) {
            if (array[index] < array[parentIndex]) {
                swapArrayIndexes(array, index, parentIndex);
                heapifyBottomToTop(parentIndex, heapType);
            }
        }
        if (heapType.equals("MAX")) {
            if (array[index] > array[parentIndex]) {
                swapArrayIndexes(array, index, parentIndex);
                heapifyBottomToTop(parentIndex, heapType);
            }
        }
    }

    private void heapifyTopToBottom(int index, String heapType) {
        int leftChild = index * 2;
        int rightChild = index * 2 + 1;
        int currentIndex = index;

        if (heapType.equals("MIN")) {
            if (leftChild <= sizeOfTree && array[leftChild] < array[currentIndex]) {
                currentIndex = leftChild;
            }
            if (rightChild <= sizeOfTree && array[rightChild] < array[currentIndex]) {
                currentIndex = rightChild;
            }
        }
        if (heapType.equals("MAX")) {
            if (leftChild <= sizeOfTree && array[leftChild] > array[currentIndex]) {
                currentIndex = leftChild;
            }
            if (rightChild <= sizeOfTree && array[rightChild] > array[currentIndex]) {
                currentIndex = rightChild;
            }
        }

        if (currentIndex != index) {
            swapArrayIndexes(array, index, currentIndex);
            heapifyTopToBottom(currentIndex, heapType);
        }
    }

    boolean isEmpty() {
        return sizeOfTree == 0;
    }

    int extractHead(String heapType) {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }

        int head = array[1]; // The root is at index 1
        array[1] = array[sizeOfTree]; // Move the last element to the root
        sizeOfTree--; // Decrease the size of the heap
        heapifyTopToBottom(1, heapType); // Restore the heap property
        return head;
    }


    public static void main(String[] args) {
        BinaryHeap heap = new BinaryHeap(7);
        heap.insert(10, "MAX");
        heap.insert(5, "MAX");
        heap.insert(15, "MAX");
        heap.insert(1, "MAX");
        heap.insert(3, "MAX");
        heap.insert(4, "MAX");
        heap.insert(20, "MAX");
        System.out.println("Heap before extraction: " + Arrays.toString(heap.array));
        int max = heap.extractHead("MAX");
        System.out.println("Extracted head: " + max);
        System.out.println("Heap after extraction: " + Arrays.toString(heap.array));
    }
}
