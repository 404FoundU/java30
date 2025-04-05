package DSA.Patterns.Heaps;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import static DSA.Utility.swapArrayIndexes;

public class BinaryHeapOld {
    int[] array;
    int sizeOfTree;

    BinaryHeapOld(int size) {
        array = new int[size + 1];
        this.sizeOfTree = 0;
    }

    void insert(int val, String heapType) {
        array[++sizeOfTree] = val; // Insert as the last element
        heapifyBottomToTop(sizeOfTree, heapType);
    }

    private void heapifyBottomToTop(int index, String heapType) {
        int parentIndex = index / 2;
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
        int swapChild = index;

        if (heapType.equals("MIN")) {
            if (leftChild <= sizeOfTree && array[leftChild] < array[swapChild]) {
                swapChild = leftChild;
            }
            if (rightChild <= sizeOfTree && array[rightChild] < array[swapChild]) {
                swapChild = rightChild;
            }
        }
        if (heapType.equals("MAX")) {
            if (leftChild <= sizeOfTree && array[leftChild] > array[swapChild]) {
                swapChild = leftChild;
            }
            if (rightChild <= sizeOfTree && array[rightChild] > array[swapChild]) {
                swapChild = rightChild;
            }
        }

        // If a swap is needed
        if (swapChild != index) {
            swapArrayIndexes(array, index, swapChild);
            heapifyTopToBottom(swapChild, heapType); // Continue heapifying downwards
        }
    }

    boolean isEmpty() {
        return sizeOfTree == 0;
    }

    int extractHead(String heapType) {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }

        // Get the root (head of the heap)
        int head = array[1];

        // Move the last element to the root
        array[1] = array[sizeOfTree];

        // Decrease the heap size
        sizeOfTree--;

        // Restore the heap property
        heapifyTopToBottom(1, heapType);

        // Return the extracted head
        return head;
    }

    void levelOrderTraversalArrayHeap() {
        Queue<Integer> q = new LinkedList<>();
        q.add(array[1]);
        int l = 1;
        while (!q.isEmpty()) {
            Integer current = q.poll();
            System.out.println(current);
            l = l * 2;
            int r = l + 1;
            if (l <= sizeOfTree) {
                q.add(array[l]);
            }
            if (r <= sizeOfTree) {
                q.add(array[r]);
            }
        }
    }


    public static void main(String[] args) {
        BinaryHeapOld heap = new BinaryHeapOld(7);
        heap.insert(20, "MAX");
        heap.insert(10, "MAX");
        heap.insert(15, "MAX");
        heap.insert(5, "MAX");
        heap.insert(1, "MAX");
        heap.insert(3, "MAX");
        heap.insert(4, "MAX");

        System.out.println("Heap before extraction: " + Arrays.toString(heap.array));

        int max = heap.extractHead("MAX");
        System.out.println("Extracted head: " + max);

        System.out.println("Heap after extraction: " + Arrays.toString(heap.array));
        heap.levelOrderTraversalArrayHeap();
    }
}


