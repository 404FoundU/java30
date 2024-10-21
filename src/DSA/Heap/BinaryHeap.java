package DSA.Heap;


import DSA.Tree.BinaryNode;

import java.util.LinkedList;
import java.util.Queue;

// 0 th index is not used
// left child = 2x
// right child = 2x+1
public class BinaryHeap {
    int arr[];
    int sizeOfTree;

    BinaryHeap(int size) {
        arr = new int[size + 1]; // skip 0th index
        sizeOfTree = 0;
    }

    boolean isEmpty() {
        if (sizeOfTree == 0) {
            return true;
        }
        return false;
    }

    Integer peek() {
        if (isEmpty()) {
            return null;
        }
        return arr[1];
    }

    void levelOrderTraversal() {
        Queue<Integer> q = new LinkedList<>();
        int leftIndex = 1;
        q.add(arr[1]);
        while (!q.isEmpty()) {
            int val = q.remove();
            System.out.println(val + " ");
            int rightIndex = leftIndex * 2 + 1;
            leftIndex = leftIndex * 2;
            if (leftIndex <= sizeOfTree) {
                q.add(arr[leftIndex]);
            }
            if (rightIndex <= sizeOfTree) {
                q.add(arr[rightIndex]);
            }
        }

        /*for (int i = 1; i <= sizeOfTree; i++) {
            System.out.println(arr[i] + " ");
        }
        System.out.println("\n");*/
    }

    void heapifyBottomToTop(int index, String heapType) {
        int parentIndex = index / 2;
        if (index <= 1) {
            return;
        }
        if (heapType.equals("MIN")) {
            if (arr[index] < arr[parentIndex]) {
                int temp = arr[parentIndex];
                arr[parentIndex] = arr[index];

                arr[index] = temp;
            }
        }
        if (heapType.equals("MAX")) {
            if (arr[index] > arr[parentIndex]) {
                int temp = arr[parentIndex];
                arr[parentIndex] = arr[index];

                arr[index] = temp;
            }
        }
        heapifyBottomToTop(parentIndex, heapType); // O(log n)
    }

    void insert(int val, String heapType) {
        arr[sizeOfTree + 1] = val;
        sizeOfTree++;
        heapifyBottomToTop(sizeOfTree, heapType);
    }

    public static void main(String[] args) {
        BinaryHeap heap = new BinaryHeap(10);
        heap.insert(10, "MAX");
        heap.insert(5, "MAX");
        heap.insert(15, "MAX");
        heap.insert(1, "MAX");
        heap.levelOrderTraversal();
    }
}
