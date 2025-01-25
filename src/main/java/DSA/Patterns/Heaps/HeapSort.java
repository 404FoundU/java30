package DSA.Patterns.Heaps;

import java.util.Arrays;

public class HeapSort {
    int[] arr = null;

    public HeapSort(int[] arr) {
        this.arr = arr;
    }

    void sort() {
        BinaryHeap heap = new BinaryHeap(arr.length);
        for (int i = 0; i < arr.length; i++) {
            heap.insert(arr[i], "MIN");
        }
        for (int j = 0; j < arr.length; j++) {
            arr[j] = heap.extractHead("MIN");
        }
    }

    void printArr() {
        Arrays.stream(arr)
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        int[] arr = {5, 17, 44, 6, 3, 1, 18};
        HeapSort sort = new HeapSort(arr);
        sort.sort();
        sort.printArr();
    }
}

